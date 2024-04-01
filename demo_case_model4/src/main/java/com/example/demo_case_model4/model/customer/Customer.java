package com.example.demo_case_model4.model.customer;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    private String nameCustomer;

    private LocalDate date_of_birth_Customer;

    private Boolean genderCustomer;

    private Long codeCustomer;

    private Long numberPhoneCustomer;

    private String emailCustomer;

    private String addressCustomer;

    @ManyToOne
    @JoinColumn(name = "id_customer_type")
    private CustomerType customerType;

    public Customer(String nameCustomer, LocalDate date_of_birth_Customer, Boolean genderCustomer, Long codeCustomer,
                    Long numberPhoneCustomer, String emailCustomer, String addressCustomer, CustomerType customerType) {
        this.nameCustomer = nameCustomer;
        this.date_of_birth_Customer = date_of_birth_Customer;
        this.genderCustomer = genderCustomer;
        this.codeCustomer = codeCustomer;
        this.numberPhoneCustomer = numberPhoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.customerType = customerType;
    }

    public Customer() {
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public LocalDate getDate_of_birth_Customer() {
        return date_of_birth_Customer;
    }

    public void setDate_of_birth_Customer(LocalDate date_of_birth_Customer) {
        this.date_of_birth_Customer = date_of_birth_Customer;
    }

    public Boolean getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Boolean genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public Long getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(Long codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public Long getNumberPhoneCustomer() {
        return numberPhoneCustomer;
    }

    public void setNumberPhoneCustomer(Long numberPhoneCustomer) {
        this.numberPhoneCustomer = numberPhoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
