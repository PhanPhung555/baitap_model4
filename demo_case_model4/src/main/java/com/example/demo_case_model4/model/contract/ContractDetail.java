package com.example.demo_case_model4.model.contract;

import jakarta.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContractDetail;

    private Double quantityContractDetail;

    @ManyToOne
    @JoinColumn(name = "id_attach_facility")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;

    public ContractDetail(Long idContractDetail, Double quantityContractDetail,
                          AttachFacility attachFacility, Contract contract) {
        this.idContractDetail = idContractDetail;
        this.quantityContractDetail = quantityContractDetail;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public ContractDetail() {
    }

    public Long getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(Long idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public Double getQuantityContractDetail() {
        return quantityContractDetail;
    }

    public void setQuantityContractDetail(Double quantityContractDetail) {
        this.quantityContractDetail = quantityContractDetail;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
