package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "Code", nullable = false, length = 20)
    private String code;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "SKU_Code", nullable = false, length = 20)
    private String skuCode;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Product_Category_ID", nullable = false)
    private ProductsCategory productCategory;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Manufacturer_ID", nullable = false)
    private Manufacturer manufacturer;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Country_Of_Origin_ID", nullable = false)
    private Country countryOfOrigin;

    @NotNull
    @Column(name = "Creation_Date_Time", nullable = false)
    private Instant creationDateTime;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Remarks", length = 500)
    private String remarks;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Description", length = 500)
    private String description;

}