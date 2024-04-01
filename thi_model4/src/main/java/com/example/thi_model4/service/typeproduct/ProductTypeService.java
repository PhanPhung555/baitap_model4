package com.example.thi_model4.service.typeproduct;

import com.example.thi_model4.model.ProductType;
import com.example.thi_model4.repository.product.IProductRepository;
import com.example.thi_model4.repository.typeProduct.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService{

    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    @Override
    public ProductType getOneProductType(Long idProductType) {
        return iProductTypeRepository.findAll().stream()
                .filter(productType -> productType.getIdProductType() == idProductType)
                .findFirst().orElse(null);
    }

    @ModelAttribute("")
    public List<ProductType> getAllProductType() {
        return iProductTypeRepository.findAll();
    }
}
