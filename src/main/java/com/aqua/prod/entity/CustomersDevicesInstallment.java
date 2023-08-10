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
@Table(name = "Customers_Devices_Installments")
public class CustomersDevicesInstallment {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_Device_ID", nullable = false)
    private CustomersDevice customerDevice;

    @NotNull
    @Column(name = "Payment_Due_Date", nullable = false)
    private LocalDate paymentDueDate;

    @NotNull
    @Column(name = "Installment_Amount", nullable = false)
    private Double installmentAmount;

    @NotNull
    @Column(name = "Paid_Amount", nullable = false)
    private Double paidAmount;

    @NotNull
    @Column(name = "Remaining_Amount", nullable = false)
    private Double remainingAmount;

    @NotNull
    @Column(name = "Collection_Date", nullable = false)
    private LocalDate collectionDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Collected_By")
    private Employee collectedBy;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}