package com.example.demo_case_model4.model.login;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String nameRole;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<User> users = new ArrayList<>();

    public Role(Long idRole, String nameRole, List<User> users) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.users = users;
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public Role() {
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
