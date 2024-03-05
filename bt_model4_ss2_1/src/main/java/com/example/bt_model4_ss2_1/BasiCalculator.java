package com.example.bt_model4_ss2_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BasiCalculator {

    @GetMapping("/showList")
    public String showList(){
        return "/list";
    }

    @GetMapping("/math")
    public String calculatorMath(Model model, @RequestParam long value1, @RequestParam long value2, @RequestParam String operation){

        String stringOfMe=operation;
        long result;
        try {
            long calculator1 = Long.parseLong(String.valueOf(value1));
            long calculator2 = Long.parseLong(String.valueOf(value2));

            switch (stringOfMe){
                case "Addition(+)":
                    result=calculator1+calculator2;
                    break;
                case "Subtraction(-)":
                    result=calculator1-calculator2;
                    break;
                case "Multiplication(X)":
                    result=calculator1*calculator2;
                    break;
                case "Division(/)":
                    result=calculator1/calculator2;
                    break;
                default:
                    model.addAttribute("message","không tìm thấy phép tính của bạn cần");
                    return "/calculatorhome";
            }
            model.addAttribute("result",result);

        }catch (NumberFormatException e){
            model.addAttribute("message","chuyển đổi giữa phép tính của bạn có vấn đề");
            return "/calculatorhome";
        }catch (ArithmeticException e){
            model.addAttribute("message","phép chia không thể nào có mẫu bằng 0");
            return "/calculatorhome";
        }

        return "/calculatorhome";


    }
}
