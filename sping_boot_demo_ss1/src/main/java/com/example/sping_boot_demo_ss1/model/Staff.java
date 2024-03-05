package com.example.sping_boot_demo_ss1.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int numberPhone;

    private Double salary;

    private String pathImage;

    private String email;

    private Long age;

    @ManyToOne
    @JoinColumn(name = "job_staff_id")
    private Job job;

    public Staff(Long id, String name, int numberPhone, Double salary, String pathImage, String email, Long age, Job job) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.salary = salary;
        this.pathImage = pathImage;
        this.email = email;
        this.age = age;
        this.job = job;
    }

    public Staff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
