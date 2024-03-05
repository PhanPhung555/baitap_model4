package com.example.bt_model4_blog_advanced.service.blog;

import com.example.bt_model4_blog_advanced.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void saveAndUpdateBlog(Blog blog);

    void removeBlog(Blog blog);

    Page<Blog> findByTitleAndCategory(Pageable pageable,String nameBlog, Long contentBlog);

    Blog getOneBlog(Long idBlog);

    List<Blog> getAllBlogSubString(Pageable pageable);

    List<Blog> getAllBlogPostsSortedByCreatedAt();
}
