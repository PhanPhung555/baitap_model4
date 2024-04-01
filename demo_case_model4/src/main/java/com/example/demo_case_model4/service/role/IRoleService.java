package com.example.demo_case_model4.service.role;

import com.example.demo_case_model4.model.login.Role;

import java.util.List;

public interface IRoleService {

    void saveAndUpdateRole(Role role);

    List<Role> getAllRole();

    Role findByNameRole(String nameRole);

    Role getRoleFindByIdRole(Long idRole );
}
