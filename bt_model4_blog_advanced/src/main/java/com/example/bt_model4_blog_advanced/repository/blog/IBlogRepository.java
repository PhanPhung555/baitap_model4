package com.example.bt_model4_blog_advanced.repository.blog;

import com.example.bt_model4_blog_advanced.model.Blog;
import com.example.bt_model4_blog_advanced.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Category> {
    @Transactional
    @Query("select b from Blog b join b.category c where b.title like %:nameBlog% and c.idCategory = :idCategory " +
            "order by b.idBlog asc")
    Page<Blog> findByTitleAndCategory(Pageable pageable,@Param("nameBlog") String nameBlog, @Param("idCategory") Long idCategory);

    Page<Blog> findAll(Pageable pageable);


}
