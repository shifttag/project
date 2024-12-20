package org.koreait.yumyum.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.yumyum.common.constant.ApiMappingPattern;
import org.koreait.yumyum.dto.ResponseDto;
import org.koreait.yumyum.dto.menu.response.MenuGetResponseDto;
import org.koreait.yumyum.dto.menu.request.MenuRequestDto;
import org.koreait.yumyum.dto.menu.response.MenuResponseDto;
import org.koreait.yumyum.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.MENU)
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    public static final String MENU_POST_ADD = "/add";
    public static final String MENU_GET_LIST = "/";
    public static final String MENU_GET_ID = "/{id}";
    public static final String MENU_PUT_UPDATE = "/update/{id}";
    public static final String MENU_DELETE = "/delete/{id}";


    // 메뉴 추가
    @PostMapping(MENU_POST_ADD)
    public ResponseEntity<ResponseDto<MenuResponseDto>> addMenu(@Valid @RequestBody MenuRequestDto dto) {
        ResponseDto<MenuResponseDto> result = menuService.addMenu(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 조회
    @GetMapping(MENU_GET_LIST)
    public ResponseEntity<ResponseDto<List<MenuGetResponseDto>>> getAllMenus(
//            @AuthenticationPrincipal String userId
    ) {
        ResponseDto<List<MenuGetResponseDto>> result = menuService.getAllMenus();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 특정 ID 메뉴 조회
    @GetMapping(MENU_GET_ID)
    public ResponseEntity<ResponseDto<MenuGetResponseDto>> getMenusById(
            @PathVariable Long id
//            @AuthenticationPrincipal String userId
    ) {
        ResponseDto<MenuGetResponseDto> result = menuService.getMenusById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 수정
    @PutMapping(MENU_PUT_UPDATE)
    public ResponseEntity<ResponseDto<MenuResponseDto>> updateMenu(
            @Valid @PathVariable Long id,
            @RequestBody MenuRequestDto dto
    ) {
        ResponseDto<MenuResponseDto> result = menuService.updateMenu(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 메뉴 삭제
    @DeleteMapping(MENU_DELETE)
    public ResponseEntity<ResponseDto<Void>> deleteMenu(@PathVariable Long id) {
        ResponseDto<Void> result = menuService.deleteMenu(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
