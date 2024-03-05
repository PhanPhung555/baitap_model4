package com.example.bt_model4_blog_advanced.service.blog;

import com.example.bt_model4_blog_advanced.model.Blog;
import com.example.bt_model4_blog_advanced.repository.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable)
                .map(blog -> {
                    if(blog.getContent().length() > 30){
                        blog.setContent(blog.getContent().substring(0,30));
                    }
                    return blog;
                });
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
    public Page<Blog> findByTitleAndCategory(Pageable pageable, String nameBlog, Long contentBlog) {
            return iBlogRepository.findByTitleAndCategory(pageable,nameBlog,contentBlog)
                    .map(blog -> {
                        if(blog.getContent().length() > 30){
                            blog.setContent(blog.getContent().substring(0,30));
                        }
                        return blog;
                    });

    }


    @Override
    public Blog getOneBlog(Long idBlog) {
        return iBlogRepository.findAll().stream()
                .filter(blog -> blog.getIdBlog() == idBlog)
                .findFirst().orElse(null);
    }

    @Override
    public List<Blog> getAllBlogSubString(Pageable pageable) {
        return iBlogRepository.findAll(pageable).stream()
                .map(blog -> {
                    if (blog.getContent().length() > 30) {
                        blog.setContent(blog.getContent().substring(0, 30));
                    }
                    return blog;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Blog> getAllBlogPostsSortedByCreatedAt() {
        List<Blog> listBlog = iBlogRepository.findAll();
        listBlog.sort(Comparator.comparing(Blog::getCreatedDateTime).reversed());
        return listBlog;
    }

}
