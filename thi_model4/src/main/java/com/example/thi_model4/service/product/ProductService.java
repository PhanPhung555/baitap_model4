package com.example.thi_model4.service.product;

import com.example.thi_model4.model.Product;
import com.example.thi_model4.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product getOneProduct(Long idProduct) {
        return iProductRepository.findAll().stream()
                .filter(product -> product.getIdProduct() == idProduct)
                .findFirst().orElse(null);
    }

    @Override
    public Page<Product> searchProduct(Pageable pageable, String nameProduct, Double priceProduc, Long idCategory) {
        return iProductRepository.findByTitleAndCategory(pageable,nameProduct,priceProduc,idCategory);
    }
}
