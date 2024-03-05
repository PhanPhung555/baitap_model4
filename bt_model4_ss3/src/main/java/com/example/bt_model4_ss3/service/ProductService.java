package com.example.bt_model4_ss3.service;

import com.example.bt_model4_ss3.model.Product;
import com.example.bt_model4_ss3.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductService implements IServiceProduct{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> listProduct() {
        return iProductRepository.listProduct();
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        iProductRepository.deleteProduct(id);
    }
}
