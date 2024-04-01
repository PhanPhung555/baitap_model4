package com.example.demo_case_model4.config;

import com.example.demo_case_model4.common.EncryptPasswordUtils;
import com.example.demo_case_model4.model.login.Role;
import com.example.demo_case_model4.model.login.User;
import com.example.demo_case_model4.repository.user_role.IRoleRepository;
import com.example.demo_case_model4.repository.user_role.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextClosedEvent> {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if(iRoleRepository.findByNameRole("ROLE_ADMIN") == null){
            iRoleRepository.save(new Role("ROLE_ADMIN"));
        }
        if(iRoleRepository.findByNameRole("ROLE_USER") == null){
            iRoleRepository.save(new Role("ROLE_USER"));
        }
        if(iUserRepository.findByUsername("admin123") == null){
            User user = new User();
            user.setUsername("admin123");
            user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils("12345"));
            List<Role> list = new ArrayList<>();
            list.add(iRoleRepository.findByNameRole("ROLE_ADMIN"));
            list.add(iRoleRepository.findByNameRole("ROLE_USER"));
            user.setRoles(list);
            iUserRepository.save(user);
        }
    }
}
