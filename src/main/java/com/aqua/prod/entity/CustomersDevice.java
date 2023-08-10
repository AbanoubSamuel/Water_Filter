package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Customers_Devices")
public class CustomersDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Device_ID", nullable = false)
    private Product device;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_Address_ID", nullable = false)
    private CustomersAddress customerAddress;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Membrane_Serial_NB", length = 100)
    private String membraneSerialNb;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Motor_Serial_NB", length = 100)
    private String motorSerialNb;

    @NotNull
    @Column(name = "Contract_Date", nullable = false)
    private LocalDate contractDate;

    @Column(name = "Installation_Date")
    private LocalDate installationDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Installments_Type_ID", nullable = false)
    private InstallmentsType installmentsType;

    @NotNull
    @Column(name = "Selling_Price", nullable = false)
    private Double sellingPrice;

    @NotNull
    @Column(name = "Down_Payment", nullable = false)
    private Double downPayment;

    @NotNull
    @Column(name = "NB_Of_Installments", nullable = false)
    private Integer nbOfInstallments;

    @NotNull
    @Column(name = "Installment_Amount", nullable = false)
    private Double installmentAmount;

    @NotNull
    @Column(name = "Free_Installation", nullable = false)
    private Boolean freeInstallation = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Column(name = "Expiry_Date")
    private LocalDate expiryDate;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}