package com.korit.spring.menus.service;

import com.korit.spring.common.ResponseMessage;
import com.korit.spring.menus.dto.request.MenuRequestDto;
import com.korit.spring.menus.dto.MenuAllResponseDto;
import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.entity.Menu;
import com.korit.spring.menus.entity.MenuCategory;
import com.korit.spring.menus.repository.MenuCategoryRepository;
import com.korit.spring.menus.repository.MenuRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService {

    @Autowired
    private final MenuRepository menuRepository;
    @Autowired
    private final MenuCategoryRepository menuCategoryRepository;

    public ResponseDto<MenuResponseDto> addMenu(@Valid MenuRequestDto dto) {
        MenuResponseDto data = null;

        try {
            Optional<MenuCategory> OptionalCategory = menuCategoryRepository.findById(dto.getCategoryId());
            if(OptionalCategory.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }

            MenuCategory category = OptionalCategory.get();
            Menu menu = Menu.builder()
                    .storeId(dto.getStoreId())
                    .menuName(dto.getMenuName())
                    .imageUrl(dto.getImageUrl())
                    .menuDescription(dto.getMenuDescription())
                    .menuPrice(dto.getMenuPrice())
                    .isAvailable(dto.getIsAvailable())
                    .menuCategory(category)
                    .build();

            Menu savedMenu = menuRepository.save(menu);
            MenuResponseDto responseDto = new MenuResponseDto(savedMenu);
            data = responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<MenuAllResponseDto>> getAllMenus() {
       List<MenuAllResponseDto> data = null;

        try {
            List<Object[]> results = menuRepository.findAllMenu();


            data = results.stream()
                    .map(result -> new MenuAllResponseDto((String) result[0], (String) result[1], (String) result[2], (Integer) result[3], (boolean) result[4], (String) result[5]))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);

        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<MenuResponseDto> updateMenu(@Valid Long id, MenuRequestDto dto) {
        MenuResponseDto data = null;

        try {
            Optional<MenuCategory> OptionalCategory = menuCategoryRepository.findById(dto.getCategoryId());
            if(OptionalCategory.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
            MenuCategory category = OptionalCategory.get();

            Optional<Menu> OptionalMenu = menuRepository.findById(id);
            if(OptionalMenu.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
            Menu menu = OptionalMenu.get();
            menu.setImageUrl(dto.getImageUrl());
            menu.setMenuName(dto.getMenuName());
            menu.setMenuDescription(dto.getMenuDescription());
            menu.setMenuPrice(dto.getMenuPrice());
            menu.setIsAvailable(dto.getIsAvailable());
            menu.setMenuCategory(category);
            menuRepository.save(menu);
            data = new MenuResponseDto(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<Void> deleteMenu(Long id) {
        try {
            Optional<Menu> optionalMenu = menuRepository.findById(id);
            if(optionalMenu.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_DATA);
            }
            menuRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, null);
    }


}
