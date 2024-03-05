package com.example.bt_model4_orm.service;

import com.example.bt_model4_orm.model.Product;
import com.example.bt_model4_orm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public void saveAndUpdateProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product getOneProduct(Long id) {
        return iProductRepository.findAll().stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
