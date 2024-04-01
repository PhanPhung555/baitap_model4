package com.example.demo_case_model4.service.accountDetailsService;

import com.example.demo_case_model4.model.login.User;
import com.example.demo_case_model4.repository.user_role.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);
        if(user != null){
            List<SimpleGrantedAuthority> list = new ArrayList<>();
            return  new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNameRole()))
                            .collect(Collectors.toList())
                    );
        }else {
            throw new UsernameNotFoundException("Invalid username or password");
        }

    }
}
