package com.example.demo_springboot_ss2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    private String nameBook;

    private Integer numberBook;

    private String author;

    private String introduce;

    public Book(String nameBook, Integer numberBook, String author, String introduce) {
        this.nameBook = nameBook;
        this.numberBook = numberBook;
        this.author = author;
        this.introduce = introduce;
    }

    public Book() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(Integer numberBook) {
        this.numberBook = numberBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
