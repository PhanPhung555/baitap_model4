package com.example.bt_model4_ss3.repository;

import com.example.bt_model4_ss3.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> listProduct();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
