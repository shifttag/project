package com.korit.fileupload_back.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReqFileUploadDto {
    private String title;
    private MultipartFile img;  // 여러개 받고싶으면 리스트 형식으로 정의
}
