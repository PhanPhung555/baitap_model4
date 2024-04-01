package com.example.demo_case_model4.model.contract;

import com.example.demo_case_model4.model.customer.Customer;
import com.example.demo_case_model4.model.employee.Employee;
import com.example.demo_case_model4.model.facility.Facility;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Contract")
public class Contract {
    @Id
    private Long idContract;

    private Date star_date_contract;

    private Date end_date_contract;

    private Double deposit;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer ;

    @ManyToOne
    @JoinColumn(name = "id_facility")
    private Facility facility;

    public Contract(Long idContract, Date star_date_contract,
                    Date end_date_contract, Double deposit, Employee employee, Customer customer, Facility facility) {
        this.idContract = idContract;
        this.star_date_contract = star_date_contract;
        this.end_date_contract = end_date_contract;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Contract() {
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }

    public Date getStar_date_contract() {
        return star_date_contract;
    }

    public void setStar_date_contract(Date star_date_contract) {
        this.star_date_contract = star_date_contract;
    }

    public Date getEnd_date_contract() {
        return end_date_contract;
    }

    public void setEnd_date_contract(Date end_date_contract) {
        this.end_date_contract = end_date_contract;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
