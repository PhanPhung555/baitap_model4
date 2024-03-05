package com.example.demo_springboot_ss2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String name;

    private Date borrowed_day;

    private Date pay_day;

    private Integer quantityBook;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;


    public User(String name, Date borrowed_day, Date pay_day, Integer quantityBook, Book book) {
        this.name = name;
        this.borrowed_day = borrowed_day;
        this.pay_day = pay_day;
        this.quantityBook = quantityBook;
        this.book = book;
    }

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorrowed_day() {
        return borrowed_day;
    }

    public void setBorrowed_day(Date borrowed_day) {
        this.borrowed_day = borrowed_day;
    }

    public Date getPay_day() {
        return pay_day;
    }

    public void setPay_day(Date pay_day) {
        this.pay_day = pay_day;
    }

    public Integer getQuantityBook() {
        return quantityBook;
    }

    public void setQuantityBook(Integer quantityBook) {
        this.quantityBook = quantityBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNumberBook() {
        return quantityBook;
    }

    public void setNumberBook(Integer numberBook) {
        this.quantityBook = numberBook;
    }
}
