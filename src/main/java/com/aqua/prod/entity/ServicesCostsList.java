package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Services_Costs_List")
public class ServicesCostsList {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Governorate_ID", nullable = false)
    private Governorate governorate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Currency_ID", nullable = false)
    private Currency currency;

    @NotNull
    @Column(name = "\"Date\"", nullable = false)
    private LocalDate date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Service_ID", nullable = false)
    private Service service;

    @NotNull
    @Column(name = "Cost", nullable = false)
    private Double cost;

    @NotNull
    @Column(name = "Commission", nullable = false)
    private Double commission;

    @NotNull
    @Column(name = "Trans_Date_Time", nullable = false)
    private Instant transDateTime;

    @Size(max = 1000)
    @NotNull
    @Nationalized
    @Column(name = "Remarks", nullable = false, length = 1000)
    private String remarks;

}