package com.example.bt_model4_blog.service;

import com.example.bt_model4_blog.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getAllBlog();

    void saveAndUpdateBlog(Blog blog);

    void removeBlog(Blog blog);

    List<Blog> searchBlog(String nameBlog);

    Blog getOneBlog(Long idBlog);

    List<Blog> getAllBlogSubString();


}
