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
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "User_Name", nullable = false, length = 200)
    private String userName;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Normalized_User_Name", nullable = false, length = 200)
    private String normalizedUserName;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "First_Name", nullable = false, length = 200)
    private String firstName;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Last_Name", nullable = false, length = 200)
    private String lastName;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Email", nullable = false, length = 200)
    private String email;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Normalized_Email", nullable = false, length = 200)
    private String normalizedEmail;

    @NotNull
    @Column(name = "Email_Confirmed", nullable = false)
    private Boolean emailConfirmed = false;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Password", nullable = false, length = 200)
    private String password;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Phone_Number", nullable = false, length = 200)
    private String phoneNumber;

    @NotNull
    @Column(name = "Phone_Number_Confirmed", nullable = false)
    private Boolean phoneNumberConfirmed = false;

    @Nationalized
    @Lob
    @Column(name = "FCM")
    private String fcm;

    @Column(name = "Image")
    private byte[] image;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "User_Type_ID", nullable = false)
    private UserType userType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @NotNull
    @Column(name = "Creation_Date_Time", nullable = false)
    private Instant creationDateTime;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}