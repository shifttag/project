package com.korit.fileupload_back.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadService {

    public void uploadFile(MultipartFile file) {
        if(file == null) {
            return;
        }

        String newFileNmae = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String rootPath = "C:/Users/ehdgu/OneDrive/바탕 화면/국비 수업/korea/upload/";

        File f = new File(rootPath, "profile");
        if(!f.exists()) {
            f.mkdirs();
        }

        Path uploadPath = Paths.get(rootPath + "profile/" + newFileNmae);
        try {
         Files.write(uploadPath, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
