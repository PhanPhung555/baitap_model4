package com.example.demo_springboot_ss2.service.user;

import com.example.demo_springboot_ss2.model.Book;
import com.example.demo_springboot_ss2.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void saveUser(User user);

    void returnBook(User user);

    User getUserById(Long idUser);
}
