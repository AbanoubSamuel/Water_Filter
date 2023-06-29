package com.aqua.prod.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "User_Name")
    private String userName;
    @Basic
    @Column(name = "Normalized_User_Name")
    private String normalizedUserName;
    @Basic
    @Column(name = "First_Name")
    private String firstName;
    @Basic
    @Column(name = "Last_Name")
    private String lastName;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Normalized_Email")
    private String normalizedEmail;
    @Basic
    @Column(name = "Email_Confirmed")
    private boolean emailConfirmed;
    @Basic
    @JsonIgnore
    @Column(name = "Password")
    private String password;
    @Basic
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Basic
    @Column(name = "Phone_Number_Confirmed")
    private boolean phoneNumberConfirmed;
    @Basic
    @Column(name = "FCM")
    private String fcm;
    @Basic
    @Column(name = "Image")
    private byte[] image;
    @Basic
    @Column(name = "Role_ID")
    private int roleId;
    @Basic
    @Column(name = "Status_ID")
    private int statusId;
    @Basic
    @Column(name = "Creation_Date_Time")
    private Date creationDateTime;
    @Basic
    @Column(name = "Description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Role_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getNormalizedUserName()
    {
        return normalizedUserName;
    }

    public void setNormalizedUserName(String normalizedUserName)
    {
        this.normalizedUserName = normalizedUserName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNormalizedEmail()
    {
        return normalizedEmail;
    }

    public void setNormalizedEmail(String normalizedEmail)
    {
        this.normalizedEmail = normalizedEmail;
    }

    public boolean isEmailConfirmed()
    {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed)
    {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberConfirmed()
    {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed)
    {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public String getFcm()
    {
        return fcm;
    }

    public void setFcm(String fcm)
    {
        this.fcm = fcm;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }

    public int getStatusId()
    {
        return statusId;
    }

    public void setStatusId(int statusId)
    {
        this.statusId = statusId;
    }

    public Date getCreationDateTime()
    {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime)
    {
        this.creationDateTime = creationDateTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && emailConfirmed == user.emailConfirmed && phoneNumberConfirmed == user.phoneNumberConfirmed && roleId == user.roleId && statusId == user.statusId && Objects.equals(userName, user.userName) && Objects.equals(normalizedUserName, user.normalizedUserName) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(normalizedEmail, user.normalizedEmail) && Objects.equals(password, user.password) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(fcm, user.fcm) && Arrays.equals(image, user.image) && Objects.equals(creationDateTime, user.creationDateTime) && Objects.equals(description, user.description);
    }

    @Override
    public int hashCode()
    {
        int result = Objects.hash(id, userName, normalizedUserName, firstName, lastName, email, normalizedEmail, emailConfirmed, password, phoneNumber, phoneNumberConfirmed, fcm, roleId, statusId, creationDateTime, description);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}

