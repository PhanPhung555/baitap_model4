package com.example.sping_boot_demo_ss1.service.uploadFile;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class UploadFileService implements IUploadFileService {

    public void upload(MultipartFile file) throws IOException {
        String folderUpload = "D:\\modul4\\sping_boot_demo_ss1\\src\\main\\resources\\static\\img\\";
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(folderUpload + fileName));
    }

    public String getPathImage(MultipartFile file) {
        return file.getOriginalFilename();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException   {

        String folderUpload = "D:\\modul4\\sping_boot_demo_ss1\\src\\main\\resources\\static\\img\\";
        Properties properties = new Properties();
        OutputStream outputStream = null;
        try {
            // Đọc tệp properties
            InputStream input = new FileInputStream(folderUpload);
            properties.load(input);
            input.close();

            // Thêm key và value vào properties
            properties.setProperty("img", file.getOriginalFilename());

            // Lưu lại properties vào tệp
            outputStream = new FileOutputStream(folderUpload);
            properties.store(outputStream, "Updated properties");
            System.out.println("Key and value saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
