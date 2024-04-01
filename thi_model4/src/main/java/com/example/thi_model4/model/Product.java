package com.example.thi_model4.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String nameProduct;

    private Double priceProduct;

    private String statusProduct;

    @ManyToOne
    @JoinColumn(name = "id_type_product")
    private ProductType productType;

    public Product(String nameProduct, Double priceProduct, String statusProduct, ProductType productType) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public Product(Long idProduct, String nameProduct, Double priceProduct, String statusProduct, ProductType productType) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.statusProduct = statusProduct;
        this.productType = productType;
    }

    public Product() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", statusProduct='" + statusProduct + '\'' +
                ", productType=" + productType +
                '}';
    }
}
