package com.example.demo_case_model4.dto.login;

import com.example.demo_case_model4.model.login.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    @NotNull
    private String username;

    @NotNull
    @Size(min = 1 , max = 10)
    private String password;

   private List<Long> roles;

    public UserDTO(String username, String password, List<Long> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
