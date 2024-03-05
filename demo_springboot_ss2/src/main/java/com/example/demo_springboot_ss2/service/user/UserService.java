package com.example.demo_springboot_ss2.service.user;

import com.example.demo_springboot_ss2.model.User;
import com.example.demo_springboot_ss2.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void returnBook(User user) {
        iUserRepository.delete(user);
    }

    @Override
    public User getUserById(Long idUser) {
        return iUserRepository.findAll().stream()
                .filter(e -> e.getIdUser() == idUser)
                .findFirst()
                .orElse(null);
    }

}
