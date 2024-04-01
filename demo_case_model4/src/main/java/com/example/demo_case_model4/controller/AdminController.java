package com.example.demo_case_model4.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user/")
@Controller
public class AdminController {

    @GetMapping
    public String nextPageAdmin(Model model){
        return "admin";
    }

//    Luôn Trả Về tên tài khoản khi đăng nhập
    @ModelAttribute("nameAccount")
    public String getNameAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  authentication.getName();
    }
}
