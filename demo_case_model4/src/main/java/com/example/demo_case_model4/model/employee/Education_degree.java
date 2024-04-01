package com.example.demo_case_model4.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Education_degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEducation_degree;

    private String nameEducation_degree;

    public Education_degree(Long idEducation_degree, String nameEducation_degree) {
        this.idEducation_degree = idEducation_degree;
        this.nameEducation_degree = nameEducation_degree;
    }

    public Education_degree() {
    }

    public Long getIdEducation_degree() {
        return idEducation_degree;
    }

    public void setIdEducation_degree(Long idEducation_degree) {
        this.idEducation_degree = idEducation_degree;
    }

    public String getNameEducation_degree() {
        return nameEducation_degree;
    }

    public void setNameEducation_degree(String nameEducation_degree) {
        this.nameEducation_degree = nameEducation_degree;
    }
}
