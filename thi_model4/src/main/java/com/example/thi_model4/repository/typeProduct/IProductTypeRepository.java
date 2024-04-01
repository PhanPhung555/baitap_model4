package com.example.thi_model4.repository.typeProduct;

import com.example.thi_model4.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType,Long> {
}
