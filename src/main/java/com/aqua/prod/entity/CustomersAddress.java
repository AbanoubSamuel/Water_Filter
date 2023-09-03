package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Customers_Addresses")
public class CustomersAddress {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @Size(max = 1000)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 1000)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Location_ID", nullable = false)
    private Location location;

    @Size(max = 1000)
    @NotNull
    @Nationalized
    @Column(name = "Landmark", nullable = false, length = 1000)
    private String landmark;

    @Column(name = "Latitude", precision = 12, scale = 9)
    private BigDecimal latitude;

    @Column(name = "Longitude", precision = 12, scale = 9)
    private BigDecimal longitude;

    @Column(name = "Location_Confirmed_By_Client")
    private Boolean locationConfirmedByClient;

    @Column(name = "Location_Confirmed_By_Technician")
    private Boolean locationConfirmedByTechnician;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Reamrks", length = 1000)
    private String reamrks;

}