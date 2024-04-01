package com.example.thi_model4.controller;

import ch.qos.logback.core.model.Model;
import com.example.thi_model4.dto.ProductDTO;
import com.example.thi_model4.model.Product;
import com.example.thi_model4.model.ProductType;
import com.example.thi_model4.service.product.IProductService;
import com.example.thi_model4.service.typeproduct.IProductTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Product>> getAllListProduct(@RequestParam(defaultValue = "0",required = false) int page){
        Pageable pageable = PageRequest.of(page,4);
        return new ResponseEntity<>(iProductService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/nextPageAdd")
    public ModelAndView nextPageAdd(){
        return new ModelAndView("/add","ProductDTO",new ProductDTO());
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("ProductDTO") ProductDTO productDTO,
                             BindingResult bindingResult, Model model) throws Exception{
        if(bindingResult.hasErrors()){
            return "/add";
        }
        Product product = new Product();
        ProductType productType = iProductTypeService.getOneProductType(productDTO.getProductType());
        BeanUtils.copyProperties(productDTO,product);
        product.setProductType(productType);
        product.setStatusProduct("Chờ Duyệt");
        iProductService.saveProduct(product);
        return "redirect:/product/list";

    }

    @GetMapping("/searchProduct")
    public ModelAndView searchProduct(@RequestParam("nameProduct") String nameProduct,
                                @RequestParam("priceProduct") Double priceProduct,
                                @RequestParam("idProductType") Long idProductType,
                                @RequestParam(defaultValue = "0",required = false) int page) {

        Pageable pageable = PageRequest.of(page,4);
        if(nameProduct.equals("")){
            return new ModelAndView("/list","listProduct",iProductService.findAll(pageable));
        }else
            return new ModelAndView("/list",
                    "listProduct",iProductService.searchProduct(pageable,nameProduct,priceProduct,idProductType));
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("idProductHidden") Long idProductHidden){
        iProductService.deleteProduct(iProductService.getOneProduct(idProductHidden));
        return "redirect:/product/list";
    }
    @ModelAttribute("listProductType")
    public List<ProductType> getAllProductType(){
        return iProductTypeService.getAllProductType();
    }
}
