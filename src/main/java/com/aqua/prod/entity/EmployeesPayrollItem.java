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
@Table(name = "Employees_Payroll_Items")
public class EmployeesPayrollItem {
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
    @JoinColumn(name = "Payroll_Item_ID", nullable = false)
    private PayrollItem payrollItem;

    @NotNull
    @Column(name = "Amount", nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "Effective_Date", nullable = false)
    private LocalDate effectiveDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    @Column(name = "Trans_Date_Time")
    private Instant transDateTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}