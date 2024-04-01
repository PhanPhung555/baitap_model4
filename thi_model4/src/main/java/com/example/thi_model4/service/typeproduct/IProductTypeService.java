package com.example.thi_model4.service.typeproduct;

import com.example.thi_model4.model.ProductType;

import java.util.List;

public interface IProductTypeService {

    ProductType getOneProductType(Long id);

    List<ProductType> getAllProductType();
}
