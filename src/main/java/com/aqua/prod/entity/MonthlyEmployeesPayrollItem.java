package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Monthly_Employees_Payroll_Items")
public class MonthlyEmployeesPayrollItem {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_ID", nullable = false)
    private Employee employee;

    @NotNull
    @Column(name = "\"Date\"", nullable = false)
    private LocalDate date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Payroll_Item_ID", nullable = false)
    private PayrollItem payrollItem;

    @NotNull
    @Column(name = "Amount", nullable = false)
    private Double amount;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Remarks", length = 500)
    private String remarks;

}