package com.example.bt_model4_orm.service;

import com.example.bt_model4_orm.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();

    void saveAndUpdateProduct(Product product);

    void deleteProduct(Product product);

    Product getOneProduct(Long id);
}
