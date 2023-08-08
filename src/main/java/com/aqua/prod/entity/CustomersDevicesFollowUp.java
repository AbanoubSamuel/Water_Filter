package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Customers_Devices_Follow_Up")
public class CustomersDevicesFollowUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_Device_ID", nullable = false)
    private CustomersDevice customerDevice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Product_Stage_ID", nullable = false)
    private ProductsStage productStage;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Installed_Item_ID", nullable = false)
    private Product installedItem;

    @NotNull
    @Column(name = "Last_Replacement_Date", nullable = false)
    private LocalDate lastReplacementDate;

    @NotNull
    @Column(name = "Replacement_Due_Date", nullable = false)
    private LocalDate replacementDueDate;

    @NotNull
    @Column(name = "Remarks", nullable = false)
    private Instant remarks;

}