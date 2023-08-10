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
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Full_Name", nullable = false, length = 200)
    private String fullName;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Nickname", nullable = false, length = 200)
    private String nickname;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "National_NB", nullable = false, length = 100)
    private String nationalNb;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Job_Title", nullable = false, length = 200)
    private String jobTitle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Default_Address_ID", nullable = false)
    private CustomersAddress defaultAddress;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Whatsapp_NB", length = 100)
    private String whatsappNb;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Mobile", length = 100)
    private String mobile;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Phone_NB", length = 100)
    private String phoneNb;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Preferred_Contact_Method_ID", nullable = false)
    private ContactMethod preferredContactMethod;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}