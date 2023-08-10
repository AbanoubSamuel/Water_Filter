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
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "National_NB", nullable = false, length = 100)
    private String nationalNb;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Gender_ID", nullable = false)
    private Gender gender;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Address", length = 1000)
    private String address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Location_ID", nullable = false)
    private Location location;

    @NotNull
    @Column(name = "Hiring_Date", nullable = false)
    private LocalDate hiringDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Department_ID", nullable = false)
    private Department department;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Position_ID", nullable = false)
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Direct_Manager_ID")
    private Employee directManager;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Attendance_Type_ID", nullable = false)
    private AttendanceType attendanceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Column(name = "Creation_Date_Time")
    private Instant creationDateTime;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}