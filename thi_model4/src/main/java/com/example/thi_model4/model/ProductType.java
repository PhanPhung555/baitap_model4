package com.example.thi_model4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductType;

    private String nameProductType;


    public ProductType(Long idProductType, String nameProductType) {
        this.idProductType = idProductType;
        this.nameProductType = nameProductType;
    }

    public ProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }

    public ProductType() {
    }

    public Long getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(Long idProductType) {
        this.idProductType = idProductType;
    }

    public String getNameProductType() {
        return nameProductType;
    }

    public void setNameProductType(String nameProductType) {
        this.nameProductType = nameProductType;
    }
}
