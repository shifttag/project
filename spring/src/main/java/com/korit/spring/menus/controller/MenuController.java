package com.korit.spring.menus.controller;

import com.korit.spring.common.ApiMappingPattern;
import com.korit.spring.menus.dto.request.MenuRequestDto;
import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.MENU)
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    public static final String MENU_POST_ADD = "/menus/add";
    public static final String MENU_GET_LIST = "/menus";
    public static final String MENU_GET_NAME = "/menus/{menuName}";
    public static final String MENU_GET_CATEGORY = "/menus/{menuCategory}";
    public static final String MENU_PUT_UPDATE = "/menus/update";
    public static final String MENU_DELETE = "/menus/delete";


    // 메뉴 추가
    @PostMapping(MENU_POST_ADD)
    public ResponseEntity<ResponseDto<MenuResponseDto>> addMenu(@Valid @RequestBody MenuRequestDto dto,
                                                                @AuthenticationPrincipal String userId) {
        ResponseDto<MenuResponseDto> result = menuService.addMenu(dto, userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 조회
    @GetMapping(MENU_GET_LIST)
    public ResponseEntity<ResponseDto<List<MenuResponseDto>>> getAllMenus() {
        ResponseDto<List<MenuResponseDto>> result = menuService.getAllMenus();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 수정
    @PutMapping(MENU_PUT_UPDATE)
    public ResponseEntity<ResponseDto<MenuResponseDto>> updateMenu(
            @Valid @PathVariable Long id,
            @AuthenticationPrincipal String userId,
            @RequestBody MenuResponseDto dto
    ) {
        ResponseDto<MenuResponseDto> result = menuService.updateMenu(id, userId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 삭제
    @DeleteMapping(MENU_DELETE)
    public ResponseEntity<ResponseDto<Void>> deleteMenu(@PathVariable Long id) {
        ResponseDto<Void> result = menuService.deleteMenu(id);
        ResponseEntity.status(HttpStatus.OK).body(result);
    }
}