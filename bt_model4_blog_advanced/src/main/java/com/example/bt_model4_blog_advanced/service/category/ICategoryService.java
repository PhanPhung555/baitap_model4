package com.example.bt_model4_blog_advanced.service.category;

import com.example.bt_model4_blog_advanced.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategory();

    Category getOneCategory(Long idCategory);
}
