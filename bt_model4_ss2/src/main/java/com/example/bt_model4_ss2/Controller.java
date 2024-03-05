package com.example.bt_model4_ss2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/home")
public class Controller {

    @GetMapping("/show")
    public String showList(){
        return "/list";

    }
    @PostMapping("/listAll")
    public String addList(Model model, @RequestParam String[]spice){
        model.addAttribute("list",spice);
        return "/showList";
    }
}
