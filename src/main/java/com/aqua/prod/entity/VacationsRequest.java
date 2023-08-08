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
@Table(name = "Vacations_Requests")
public class VacationsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Vacation_Type_ID", nullable = false)
    private VacationsType vacationType;

    @NotNull
    @Column(name = "From_Date", nullable = false)
    private LocalDate fromDate;

    @NotNull
    @Column(name = "To_Dates", nullable = false)
    private LocalDate toDates;

    @NotNull
    @Column(name = "Days", nullable = false)
    private Integer days;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @NotNull
    @Column(name = "Trans_Date_Time", nullable = false)
    private Instant transDateTime;

    @NotNull
    @Column(name = "Approved_By", nullable = false)
    private Integer approvedBy;

    @NotNull
    @Column(name = "Approval_Date", nullable = false)
    private Instant approvalDate;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}