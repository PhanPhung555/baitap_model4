package com.example.demo_case_model4.model.facility;

import jakarta.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacility;

    private String nameFacility;

    private Double constFacility;

    private int max_peopleFacility;

    private String standard_room;

    private double pool_area;

    private int number_of_floors;

    private String facility_free;

    @ManyToOne
    @JoinColumn(name = "id_rent_type")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "id_facility_type")
    private FacilityType facilityType;


    public Facility(Long idFacility, String nameFacility, Double constFacility, int max_peopleFacility, String standard_room,
                    double pool_area, int number_of_floors, String facility_free, RentType rentType, FacilityType facilityType) {
        this.idFacility = idFacility;
        this.nameFacility = nameFacility;
        this.constFacility = constFacility;
        this.max_peopleFacility = max_peopleFacility;
        this.standard_room = standard_room;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.facility_free = facility_free;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Facility() {
    }

    public Long getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Long idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public Double getConstFacility() {
        return constFacility;
    }

    public void setConstFacility(Double constFacility) {
        this.constFacility = constFacility;
    }

    public int getMax_peopleFacility() {
        return max_peopleFacility;
    }

    public void setMax_peopleFacility(int max_peopleFacility) {
        this.max_peopleFacility = max_peopleFacility;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
