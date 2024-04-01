package com.example.demo_case_model4.repository.user_role;

import com.example.demo_case_model4.model.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Long> {

    Role findByNameRole(String nameRole);

}
