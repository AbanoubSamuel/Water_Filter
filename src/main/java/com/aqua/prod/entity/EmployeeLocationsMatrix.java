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
@Table(name = "Employee_Locations_Matrix")
public class EmployeeLocationsMatrix {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Location_ID", nullable = false)
    private Location location;

    @NotNull
    @Column(name = "Trans_Date_Time", nullable = false)
    private Instant transDateTime;

    @Size(max = 500)
    @NotNull
    @Nationalized
    @Column(name = "Remarks", nullable = false, length = 500)
    private String remarks;

}