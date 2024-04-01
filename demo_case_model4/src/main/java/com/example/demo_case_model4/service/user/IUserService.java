package com.example.demo_case_model4.service.user;

import com.example.demo_case_model4.model.login.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    void saveAndUpdateUser(User user);

    Page<User> findAll(Pageable pageable);

}
