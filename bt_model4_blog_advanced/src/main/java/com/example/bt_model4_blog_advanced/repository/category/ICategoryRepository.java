package com.example.bt_model4_blog_advanced.repository.category;

import com.example.bt_model4_blog_advanced.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
