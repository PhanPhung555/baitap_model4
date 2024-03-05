package com.example.demo_springboot_ss2.service.book;

import com.example.demo_springboot_ss2.model.Book;

import java.util.List;

public interface IBookService {

    List<Book> getAllBook();

    void saveAndUpdate(Book book);

    void removeBook(Book book);


    void searchBook(String nameBook);

    void updatenumberBook(Long idbook, Long numberBook);

    void updateIncreasenumberBook(Long idbook, Long numberBook);

    Book getBookId(Long idbook);
}
