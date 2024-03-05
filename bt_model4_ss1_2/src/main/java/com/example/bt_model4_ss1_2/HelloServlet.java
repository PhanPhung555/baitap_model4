package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class Dictionary {
    private static final String[][] dictionaryList = {
            {"hello", "xin chào"},
            {"bye", "tạm biêt"},
            {"word", "thế giới"},
            {"icon", "biểu tượng"},
            {"computer", "máy tính"},
    };
    @GetMapping("/enterList")
    public String enterDictionary(){
        return "/showList";
    }
    @GetMapping("/searchList")
    public String searchDictionary(@RequestParam String key, Model model){
        String stringOfMe=findMeaning(key);
        if (stringOfMe!=null){
            model.addAttribute("key",key);
            model.addAttribute("value",stringOfMe);
            return "/result";
        }else {
            model.addAttribute("message","đối tượng không tìm thấy");
            return "/listnull";
        }
    }
    public String findMeaning(String string){
        for (String[] strings:dictionaryList){
            if (strings[0].equalsIgnoreCase(string)){
                return strings[1];
            }
        }
        return null;
    }

}