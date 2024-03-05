package com.example.sping_boot_demo_ss1.model;

import org.springframework.web.multipart.MultipartFile;

public class Upload {

    private MultipartFile imgStaff;

    public Upload(MultipartFile imgStaff) {
        this.imgStaff = imgStaff;
    }

    public Upload() {
    }

    public MultipartFile getImgStaff() {
        return imgStaff;
    }

    public void setImgStaff(MultipartFile imgStaff) {
        this.imgStaff = imgStaff;
    }
}
