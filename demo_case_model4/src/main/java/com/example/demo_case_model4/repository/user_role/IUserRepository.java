package com.example.demo_case_model4.repository.user_role;

import com.example.demo_case_model4.model.login.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

//    @Transactional
//    @Modifying
//    @Query("select u from User u join u.roles r where u.username = :username")
//    Page<User> findAll(Pageable pageable, @Param("username") String username);
    Page<User> findAll(Pageable pageable);
}
