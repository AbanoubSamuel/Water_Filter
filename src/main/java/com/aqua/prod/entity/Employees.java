package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Employees {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Code")
    private String code;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "User_ID")
    private Integer userId;
    @Basic
    @Column(name = "National_NB")
    private int nationalNb;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Gender_ID")
    private int genderId;
    @Basic
    @Column(name = "Mobile")
    private String mobile;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "Location_ID")
    private int locationId;
    @Basic
    @Column(name = "Hiring_Date")
    private Date hiringDate;
    @Basic
    @Column(name = "Department_ID")
    private int departmentId;
    @Basic
    @Column(name = "Position_ID")
    private int positionId;
    @Basic
    @Column(name = "Image")
    private byte[] image;
    @Basic
    @Column(name = "Attendance_Type_ID")
    private int attendanceTypeId;
    @Basic
    @Column(name = "Status_ID")
    private int statusId;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public int getNationalNb()
    {
        return nationalNb;
    }

    public void setNationalNb(int nationalNb)
    {
        this.nationalNb = nationalNb;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getGenderId()
    {
        return genderId;
    }

    public void setGenderId(int genderId)
    {
        this.genderId = genderId;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getLocationId()
    {
        return locationId;
    }

    public void setLocationId(int locationId)
    {
        this.locationId = locationId;
    }

    public Date getHiringDate()
    {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate)
    {
        this.hiringDate = hiringDate;
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(int departmentId)
    {
        this.departmentId = departmentId;
    }

    public int getPositionId()
    {
        return positionId;
    }

    public void setPositionId(int positionId)
    {
        this.positionId = positionId;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public int getAttendanceTypeId()
    {
        return attendanceTypeId;
    }

    public void setAttendanceTypeId(int attendanceTypeId)
    {
        this.attendanceTypeId = attendanceTypeId;
    }

    public int getStatusId()
    {
        return statusId;
    }

    public void setStatusId(int statusId)
    {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id && nationalNb == employees.nationalNb && genderId == employees.genderId && locationId == employees.locationId && departmentId == employees.departmentId && positionId == employees.positionId && attendanceTypeId == employees.attendanceTypeId && statusId == employees.statusId && Objects.equals(code, employees.code) && Objects.equals(name, employees.name) && Objects.equals(userId, employees.userId) && Objects.equals(email, employees.email) && Objects.equals(mobile, employees.mobile) && Objects.equals(address, employees.address) && Objects.equals(hiringDate, employees.hiringDate) && Arrays.equals(image, employees.image);
    }

    @Override
    public int hashCode()
    {
        int result = Objects.hash(id, code, name, userId, nationalNb, email, genderId, mobile, address, locationId, hiringDate, departmentId, positionId, attendanceTypeId, statusId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
