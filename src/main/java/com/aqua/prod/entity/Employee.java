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

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "Code", nullable = false, length = 20)
    private String code;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @NotNull
    @Column(name = "National_NB", nullable = false)
    private Integer nationalNb;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Gender_ID", nullable = false)
    private Gender gender;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Mobile", nullable = false, length = 100)
    private String mobile;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Address", length = 500)
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

    @Column(name = "Image")
    private byte[] image;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Attendance_Type_ID", nullable = false)
    private AttendanceType attendanceType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Column(name = "Creation_Date_Time")
    private Instant creationDateTime;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Remarks", length = 500)
    private String remarks;

}