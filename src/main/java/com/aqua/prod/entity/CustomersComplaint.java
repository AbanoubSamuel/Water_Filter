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
@Table(name = "Customers_Complaints")
public class CustomersComplaint {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Nationalized
    @Column(name = "Code", nullable = false, length = 20)
    private String code;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_Device_ID")
    private CustomersDevice customerDevice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Complaint_Category_ID", nullable = false)
    private ComplaintsCategory complaintCategory;

    @Column(name = "Table_Reference_ID")
    private Integer tableReferenceId;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Details", length = 1000)
    private String details;

    @NotNull
    @Column(name = "Complaint_Date", nullable = false)
    private LocalDate complaintDate;

    @NotNull
    @Column(name = "Issuing_Date", nullable = false)
    private Instant issuingDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @NotNull
    @Column(name = "Status_ID", nullable = false)
    private Integer statusId;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}