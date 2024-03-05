package com.example.bt_model4_ss1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class MoneyController {

    @GetMapping("/netxMoney")
    public String money(@RequestParam("money") Long money, Model model){
        Long a = money * 23000;
        model.addAttribute("money" , a);
        return "/index";
    }
}
