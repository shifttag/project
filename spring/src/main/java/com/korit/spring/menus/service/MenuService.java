package com.korit.spring.menus.service;

import com.korit.spring.common.ResponseMessage;
import com.korit.spring.menus.dto.request.MenuCategoryRequestDto;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuCategoryRepository menuCategoryRepository;

    public ResponseDto<MenuResponseDto> addMenu(@Valid MenuRequestDto dto) {
//        MenuResponseDto data = null;
//
//        try {
//
//            Menu menu = Menu.builder()
//                    .menuName(dto.getMenuName())
//                    .imageUrl(dto.getImageUrl())
//                    .menuDescription(dto.getMenuDescription())
//                    .menuPrice(dto.getMenuPrice())
//                    .isAvailable(dto.getIsAvailable())
//                    .category(dto.get)
//                    .build();
//
//            menuRepository.save(menu);
//            menuCategoryRepository.save(menuCategory);
//
//            data = new MenuAllResponseDto();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//        }
//        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
//
        return null;
    }

    public ResponseDto<List<MenuResponseDto>> getAllMenus() {
       List<MenuResponseDto> data = null;

        try {
            List<MenuAllResponseDto> menus = menuRepository.findAllMenu();


            data = menus.stream()
                    .map(MenuResponseDto::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);

        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<MenuResponseDto> updateMenu(@Valid Long id, MenuResponseDto dto) {
        return null;
    }

    public ResponseDto<Void> deleteMenu(Long id) {
        return null;
    }
}
