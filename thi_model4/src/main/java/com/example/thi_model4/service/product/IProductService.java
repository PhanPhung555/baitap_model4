package com.example.thi_model4.service.product;

import com.example.thi_model4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    void saveProduct(Product product);

    void deleteProduct(Product product);

    Product getOneProduct(Long idProduct);

    Page<Product> searchProduct(Pageable pageable,String nameProduct,Double priceProduc,Long idCategory);

}
