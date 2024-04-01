package com.example.demo_case_model4.model.facility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRent;

    private String nameRent;

    public RentType(Long idRent, String nameRent) {
        this.idRent = idRent;
        this.nameRent = nameRent;
    }

    public RentType() {
    }

    public Long getIdRent() {
        return idRent;
    }

    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }

    public String getNameRent() {
        return nameRent;
    }

    public void setNameRent(String nameRent) {
        this.nameRent = nameRent;
    }
}
