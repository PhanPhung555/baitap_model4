package com.example.bt_model4_orm.controller;

import com.example.bt_model4_orm.model.Product;
import com.example.bt_model4_orm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ModelAndView getAllProduct(){
        return new ModelAndView("/home","list",iProductService.getAllProduct());
    }

    @PostMapping("/add")
    public String addPrduct(@ModelAttribute("Product") Product product){
        iProductService.saveAndUpdateProduct(product);
        return "redirect:/home/list";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("Product") Product product){
        iProductService.saveAndUpdateProduct(product);
        return "redirect:/home/list";
    }

    @GetMapping("/nextPageAdd")
    public ModelAndView nextPageAdd(){
        return new ModelAndView("/add","Product",new Product());
    }

    @GetMapping("{id}/nextPageUpdate")
    public ModelAndView nextPageUpdate(@PathVariable("id") Long id){
        return new ModelAndView("/update","Product",iProductService.getOneProduct(id));
    }

    @GetMapping("{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id){
        iProductService.deleteProduct(iProductService.getOneProduct(id));
        return "redirect:/home/list";
    }
}
