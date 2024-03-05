package com.example.bt_model4_blog_advanced.service.category;

import com.example.bt_model4_blog_advanced.model.Category;
import com.example.bt_model4_blog_advanced.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category getOneCategory(Long idCategory) {
        return iCategoryRepository.findAll().stream()
                .filter(category -> category.getIdCategory() == idCategory)
                .findFirst().orElse(null);
    }
}
