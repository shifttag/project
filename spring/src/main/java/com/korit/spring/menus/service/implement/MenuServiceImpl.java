package com.korit.spring.menus.service.implement;

import com.korit.spring.common.ResponseMessage;
import com.korit.spring.menus.controller.MenuController;
import com.korit.spring.menus.dto.request.MenuCategoryRequestDto;
import com.korit.spring.menus.dto.request.MenuRequestDto;
import com.korit.spring.menus.dto.MenuAllResponseDto;
import com.korit.spring.menus.dto.response.MenuCategoryResponseDto;
import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.entity.Menu;
import com.korit.spring.menus.entity.MenuCategory;
import com.korit.spring.menus.repository.MenuCategoryRepository;
import com.korit.spring.menus.repository.MenuRepository;
import com.korit.spring.menus.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl extends MenuService {

    @Autowired
    private final MenuRepository menuRepository;
    @Autowired
    private final MenuCategoryRepository menuCategoryRepository;
    @Autowired
    private MenuController menuController;

    public ResponseDto<MenuResponseDto> addMenu(@Valid MenuRequestDto dto) {
        MenuResponseDto data = null;

        try {
            Menu menu = Menu.builder()
                    .storeId(dto.getStoreId())
                    .menuName(dto.getMenuName())
                    .imageUrl(dto.getImageUrl())
                    .menuDescription(dto.getMenuDescription())
                    .menuPrice(dto.getMenuPrice())
                    .isAvailable(dto.getIsAvailable())
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
            List<Menu> menus = menuRepository.findAll();
            List<MenuResponseDto> menuResponseDtos = menus.stream()
                    .map(this::convertToMenuResponseDto)
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


    private MenuResponseDto convertToMenuResponseDto(Menu menu) {
        List<MenuCategoryResponseDto> menuCategoryResponseDto = menuCategoryRepository.findById(menu.getMenuCategory().getId())
                .stream()
                .map(menuCategory -> new MenuCategoryResponseDto(
                        menuCategory.getMenuCategory()
                )).collect(Collectors.toList());

        return new MenuResponseDto(
                menu.getMenuName(),
                menu.getImageUrl(),
                menu.getMenuDescription(),
                menu.getMenuPrice(),
                menu.getIsAvailable(),
                menu.getMenuCategory().getMenuCategory(),
                menu.getStoreId(),
                menu.getMenuCategory().getId()
        );
    }

}
