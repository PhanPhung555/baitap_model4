package com.example.demo_case_model4.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPasswordUtils {
    public static String EncryptPasswordUtils(String password) {
        BCryptPasswordEncoder bCryptPasswordEncodery = new BCryptPasswordEncoder();
        return bCryptPasswordEncodery.encode(password);
    }

    public static Boolean ParseEncrypt(String originalpassword,String encryptionpassword){
        BCryptPasswordEncoder bCryptPasswordEncodery = new BCryptPasswordEncoder();
        return bCryptPasswordEncodery.matches(originalpassword,encryptionpassword);
    }
}
