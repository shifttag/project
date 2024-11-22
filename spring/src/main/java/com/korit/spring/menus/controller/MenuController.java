package com.korit.spring.menus.controller;

import com.korit.spring.common.ApiMappingPattern;
import com.korit.spring.common.ResponseMessage;
import com.korit.spring.menus.dto.MenuAllResponseDto;
import com.korit.spring.menus.dto.request.MenuRequestDto;
import com.korit.spring.menus.dto.response.MenuResponseDto;
import com.korit.spring.menus.dto.response.ResponseDto;
import com.korit.spring.menus.service.implement.MenuServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.MENU)
@RequiredArgsConstructor
public class MenuController {
    private final MenuServiceImpl menuService;

    public static final String MENU_POST_ADD = "/add";
    public static final String MENU_GET_LIST = "/";
    public static final String MENU_GET_NAME = "/{menuName}";
    public static final String MENU_GET_CATEGORY = "/{menuCategory}";
    public static final String MENU_PUT_UPDATE = "/update/{id}";
    public static final String MENU_DELETE = "/delete/{id}";


    // 메뉴 추가
    @PostMapping(MENU_POST_ADD)
    public ResponseEntity<ResponseDto<MenuResponseDto>> addMenu(@Valid @RequestBody MenuRequestDto dto) {
        ResponseDto<MenuResponseDto> response = menuService.addMenu(dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 메뉴 조회
    @GetMapping(MENU_GET_LIST)
    public ResponseEntity<ResponseDto<List<MenuAllResponseDto>>> getAllMenus() {
        ResponseDto<List<MenuAllResponseDto>> response = menuService.getAllMenus();
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 메뉴 수정
    @PutMapping(MENU_PUT_UPDATE)
    public ResponseEntity<ResponseDto<MenuResponseDto>> updateMenu(
            @Valid @PathVariable Long id,
            @RequestBody MenuRequestDto dto
    ) {
        ResponseDto<MenuResponseDto> response = menuService.updateMenu(id, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    // 메뉴 삭제
    @DeleteMapping(MENU_DELETE)
    public ResponseEntity<ResponseDto<Void>> deleteMenu(@PathVariable Long id) {
        ResponseDto<Void> response = menuService.deleteMenu(id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }
}
