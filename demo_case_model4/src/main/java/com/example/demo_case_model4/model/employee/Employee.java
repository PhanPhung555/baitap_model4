package com.example.demo_case_model4.model.employee;

import com.example.demo_case_model4.model.login.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    private LocalDate date_of_birth_Employee;

    private Long codeEmployee;

    private Long numberPhoneEmployee;

    private String emailEmployee;

    private String addressEmployee;

    @ManyToOne
    @JoinColumn(name = "id_division")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "id_education_degree")
    private Education_degree education_degree;

    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "user_name")
    private User users;

    public Employee(LocalDate date_of_birth_Employee, Long codeEmployee, Long numberPhoneEmployee, String emailEmployee,
                    String addressEmployee, Division division, Education_degree education_degree,
                    Position position, User users) {
        this.date_of_birth_Employee = date_of_birth_Employee;
        this.codeEmployee = codeEmployee;
        this.numberPhoneEmployee = numberPhoneEmployee;
        this.emailEmployee = emailEmployee;
        this.addressEmployee = addressEmployee;
        this.division = division;
        this.education_degree = education_degree;
        this.position = position;
        this.users = users;
    }

    public Employee() {
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public LocalDate getDate_of_birth_Employee() {
        return date_of_birth_Employee;
    }

    public void setDate_of_birth_Employee(LocalDate date_of_birth_Employee) {
        this.date_of_birth_Employee = date_of_birth_Employee;
    }

    public Long getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(Long codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public Long getNumberPhoneEmployee() {
        return numberPhoneEmployee;
    }

    public void setNumberPhoneEmployee(Long numberPhoneEmployee) {
        this.numberPhoneEmployee = numberPhoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Education_degree getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(Education_degree education_degree) {
        this.education_degree = education_degree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
