package com.example.bt_model4_blog.service;

import com.example.bt_model4_blog.model.Blog;
import com.example.bt_model4_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return iBlogRepository.findAll();
    }

    @Override
    public void saveAndUpdateBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void removeBlog(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public List<Blog> searchBlog(String nameBlog) {
        return iBlogRepository.findAll().stream()
                .filter(blog -> blog.getTitle().equals(nameBlog))
                .collect(Collectors.toList());
    }

    @Override
    public Blog getOneBlog(Long idBlog) {
        return iBlogRepository.findAll().stream()
                .filter(blog -> blog.getId()== idBlog)
                .findFirst().orElse(null);
    }

    @Override
    public List<Blog> getAllBlogSubString() {
        return  iBlogRepository.findAll().stream()
                .map(blog -> {

                    if(blog.getContent().length() > 20){
                        blog.setContent(blog.getContent().substring(0,70) + "...");
                    }
                    return blog;
                }).collect(Collectors.toList());
    }
}
