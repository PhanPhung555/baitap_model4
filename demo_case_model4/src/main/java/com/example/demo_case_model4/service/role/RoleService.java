package com.example.demo_case_model4.service.role;

import com.example.demo_case_model4.model.login.Role;
import com.example.demo_case_model4.repository.user_role.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public void saveAndUpdateRole(Role role) {
        iRoleRepository.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role findByNameRole(String nameRole) {
        return iRoleRepository.findByNameRole(nameRole);
    }

    @Override
    public Role getRoleFindByIdRole(Long idRole) {
        return iRoleRepository.findAll().stream()
                .filter(e -> e.getIdRole() == idRole)
                .findFirst().orElse(null);
    }
}
