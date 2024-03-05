package com.example.demo_springboot_ss2.repository.book;

import com.example.demo_springboot_ss2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    @Transactional
    @Modifying
    @Query("update Book b set b.numberBook = b.numberBook - :count where b.idBook = :id")
    void updatenumberBook(@Param("id") Long idbook,@Param("count") Long numberBook);

    @Transactional
    @Modifying
    @Query("update Book b set b.numberBook = b.numberBook + :count where b.idBook = :id")
    void updateIncreasenumberBook(@Param("id") Long idbook,@Param("count") Long numberBook);

}
