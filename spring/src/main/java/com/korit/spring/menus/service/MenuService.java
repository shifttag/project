package com.korit.spring.menus.service;

import com.korit.spring.menus.dto.request.MenuRequestDto;
import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.entity.Menu;
import com.korit.spring.menus.repository.MenuRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public ResponseDto<MenuResponseDto> addMenu(@Valid MenuRequestDto dto, String userId) {
        MenuResponseDto data = null;

        try {
            Menu menu = Menu.builder()
                    .menuName(dto.getMenuName())
                    .imageUrl(dto.getImageUrl())
                    .menuDescription(dto.getMenuDescription())
                    .menuPrice(dto.getMenuPrice())
                    .isAvailable(dto.getIsAvailable())
                    .build();
        }
    }

    public ResponseDto<List<MenuResponseDto>> getAllMenus() {
        return null;
    }

    public ResponseDto<MenuResponseDto> updateMenu(@Valid Long id, String userId, MenuResponseDto dto) {
        return null;
    }

    public ResponseDto<Void> deleteMenu(Long id) {
        return null;
    }
}
