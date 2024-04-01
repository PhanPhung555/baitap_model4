package com.example.demo_case_model4.model.facility;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacilityType;

    private String nameFacilityType;

    public FacilityType(Long idFacilityType, String nameFacilityType) {
        this.idFacilityType = idFacilityType;
        this.nameFacilityType = nameFacilityType;
    }

    public FacilityType() {
    }

    public Long getIdFacilityType() {
        return idFacilityType;
    }

    public void setIdFacilityType(Long idFacilityType) {
        this.idFacilityType = idFacilityType;
    }

    public String getNameFacilityType() {
        return nameFacilityType;
    }

    public void setNameFacilityType(String nameFacilityType) {
        this.nameFacilityType = nameFacilityType;
    }
}
