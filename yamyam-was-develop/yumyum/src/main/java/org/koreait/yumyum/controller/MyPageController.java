package org.koreait.yumyum.controller;

import com.mysql.cj.LicenseConfiguration;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.map.IdentityMap;
import org.apache.coyote.Response;
import org.koreait.yumyum.common.constant.ApiMappingPattern;
import org.koreait.yumyum.dto.ResponseDto;
import org.koreait.yumyum.dto.user.request.UserRequestDto;
import org.koreait.yumyum.dto.user.response.UserResponseDto;
import org.koreait.yumyum.service.MyPageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiMappingPattern.MYPAGE)
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    public static final String MYPAGE_GET = "/{id}";
    public static final String MYPAGE_UPDATE = "/update/{id}";
    public static final String MYPAGE_DELETE = "/delete/{id}";

    @GetMapping(MYPAGE_GET)
    public ResponseEntity<ResponseDto<UserResponseDto>> getAllInfo(@PathVariable Long id) {
        ResponseDto<UserResponseDto> response = myPageService.getAllInfo(id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @PutMapping(MYPAGE_UPDATE)
    public ResponseEntity<ResponseDto<UserResponseDto>> updateUserInfo(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        ResponseDto<UserResponseDto> response = myPageService.updateUserInfo(id, dto);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }

    @DeleteMapping(MYPAGE_DELETE)
    public ResponseEntity<ResponseDto<Void>> deleteUserInfo(@PathVariable Long id) {
        ResponseDto<Void> response = myPageService.deleteUserInfo(id);
        HttpStatus status = response.isResult() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(response);
    }


}
