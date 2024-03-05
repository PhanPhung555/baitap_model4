package com.example.bt_model4_ss3.service;

import com.example.bt_model4_ss3.model.Product;

import java.util.List;

public interface IServiceProduct {

    List<Product> listProduct();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
