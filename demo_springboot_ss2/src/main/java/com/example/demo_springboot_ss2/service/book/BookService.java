package com.example.demo_springboot_ss2.service.book;

import com.example.demo_springboot_ss2.model.Book;
import com.example.demo_springboot_ss2.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> getAllBook() {
        return iBookRepository.findAll();
    }

    @Override
    public void saveAndUpdate(Book book) {
        iBookRepository.save(book);
    }


    @Override
    public void removeBook(Book book) {

    }

    @Override
    public void searchBook(String nameBook) {

    }

    @Override
    public void updatenumberBook(Long idbook, Long numberBook) {
        iBookRepository.updatenumberBook(idbook,numberBook);
    }

    @Override
    public void updateIncreasenumberBook(Long idbook, Long numberBook) {
        iBookRepository.updateIncreasenumberBook(idbook,numberBook);
    }

    @Override
    public Book getBookId(Long idbook) {
        return iBookRepository.findAll().stream()
                .filter(e -> e.getIdBook() == idbook)
                .findFirst()
                .orElse(null);
    }
}
