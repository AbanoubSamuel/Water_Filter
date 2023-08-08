package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Products_Stages")
public class ProductsStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Device_ID", nullable = false)
    private Product device;

    @NotNull
    @Column(name = "Serial", nullable = false)
    private Integer serial;

    @NotNull
    @Column(name = "Stage_NB", nullable = false)
    private Integer stageNb;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Stage_Type_ID", nullable = false)
    private ProductsStagesType stageType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Stage_Item_ID", nullable = false)
    private Product stageItem;

    @NotNull
    @Column(name = "Mandatory_Replacement", nullable = false)
    private Boolean mandatoryReplacement = false;

    @NotNull
    @Column(name = "Replacment_Months", nullable = false)
    private Integer replacmentMonths;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}