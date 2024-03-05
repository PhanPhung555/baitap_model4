package com.example.demo_springboot_ss2.repository.user;

import com.example.demo_springboot_ss2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
