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
@Table(name = "Products_Images")
public class ProductsImage {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Product_ID", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "Image", nullable = false)
    private byte[] image;

    @NotNull
    @Column(name = "Preference_NB", nullable = false)
    private Integer preferenceNb;

    @NotNull
    @Column(name = "Show_In_Galary", nullable = false)
    private Boolean showInGalary = false;

    @NotNull
    @Column(name = "Show_In_Store", nullable = false)
    private Boolean showInStore = false;

    @Size(max = 1000)
    @NotNull
    @Nationalized
    @Column(name = "Remarks", nullable = false, length = 1000)
    private String remarks;

}