package com.example.sping_boot_demo_ss1.service.uploadFile;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUploadFileService {
    void uploadFile(MultipartFile file) throws IOException;
}
