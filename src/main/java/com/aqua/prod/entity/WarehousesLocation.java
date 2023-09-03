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
@Table(name = "Warehouses_Locations")
public class WarehousesLocation {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Plant_Code", nullable = false, length = 50)
    private String plantCode;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Warehouse_Section_ID", nullable = false)
    private WarehousesSection warehouseSection;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}