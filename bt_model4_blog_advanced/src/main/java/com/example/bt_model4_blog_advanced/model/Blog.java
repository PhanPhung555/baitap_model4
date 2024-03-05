package com.example.bt_model4_blog_advanced.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Comparator;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBlog;

    private String title;
    private String content;
    private String author;
    private LocalDateTime createdDateTime;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Blog(Long idBlog, String title, String content, String author, LocalDateTime createdDateTime, Category category) {
        this.idBlog = idBlog;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDateTime = createdDateTime;
        this.category = category;
    }

    public Blog() {

    }

    public Long getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Long idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "idBlog=" + idBlog +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", category=" + category +
                '}';
    }


}
