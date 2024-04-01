package com.example.demo_case_model4.model.contract;

import jakarta.persistence.*;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttachFacility;

    private String nameAttachFacility;

    private Double constAttachFacility;

    private String unitAttachFacility;

    private String statusAttachFacility;

    public AttachFacility(Long idAttachFacility, String nameAttachFacility,
                          Double constAttachFacility, String unitAttachFacility, String statusAttachFacility) {
        this.idAttachFacility = idAttachFacility;
        this.nameAttachFacility = nameAttachFacility;
        this.constAttachFacility = constAttachFacility;
        this.unitAttachFacility = unitAttachFacility;
        this.statusAttachFacility = statusAttachFacility;
    }

    public AttachFacility() {
    }

    public Long getIdAttachFacility() {
        return idAttachFacility;
    }

    public void setIdAttachFacility(Long idAttachFacility) {
        this.idAttachFacility = idAttachFacility;
    }

    public String getNameAttachFacility() {
        return nameAttachFacility;
    }

    public void setNameAttachFacility(String nameAttachFacility) {
        this.nameAttachFacility = nameAttachFacility;
    }

    public Double getConstAttachFacility() {
        return constAttachFacility;
    }

    public void setConstAttachFacility(Double constAttachFacility) {
        this.constAttachFacility = constAttachFacility;
    }

    public String getUnitAttachFacility() {
        return unitAttachFacility;
    }

    public void setUnitAttachFacility(String unitAttachFacility) {
        this.unitAttachFacility = unitAttachFacility;
    }

    public String getStatusAttachFacility() {
        return statusAttachFacility;
    }

    public void setStatusAttachFacility(String statusAttachFacility) {
        this.statusAttachFacility = statusAttachFacility;
    }
}
