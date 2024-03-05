package com.example.bt_model4_ss3.controller;

import com.example.bt_model4_ss3.model.Product;
import com.example.bt_model4_ss3.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class ProductController {

    @Autowired
    private IServiceProduct iServiceProduct;
    @GetMapping("/list")
    public ModelAndView getAllProduct(){
        return new ModelAndView("/home","list",iServiceProduct.listProduct());
    }

    @PostMapping("/add")
    public String addPrduct(@ModelAttribute("Product") Product product){
        iServiceProduct.addProduct(product);
        return "redirect:/home/list";
    }

    @GetMapping("/nextPageAdd")
    public ModelAndView nextPageAdd(){
        return new ModelAndView("/create","Product",new Product());
    }
    @GetMapping("{id}/nextPageUpdate")
    public ModelAndView nextPageUpdate(@PathVariable("id") Long id){
       Product p = iServiceProduct.listProduct().stream()
                .filter(product -> product.getId() == id)
                .findFirst().orElse(null);
        return new ModelAndView("/update","Product",p);
    }
    @GetMapping("{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id){
        iServiceProduct.deleteProduct(id);
        return "redirect:/home/list";
    }
}
