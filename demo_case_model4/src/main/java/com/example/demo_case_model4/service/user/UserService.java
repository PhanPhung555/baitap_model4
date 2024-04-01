package com.example.demo_case_model4.service.user;

import com.example.demo_case_model4.common.EncryptPasswordUtils;
import com.example.demo_case_model4.model.login.User;
import com.example.demo_case_model4.repository.user_role.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void saveAndUpdateUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable)
                .map(user -> {
            if(user.getPassword() != null && !user.getPassword().isEmpty()){
                user.setPassword("*****");
            }
            return user;
        });
    }




}
