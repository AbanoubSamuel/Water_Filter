package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Users_Roles", schema = "dbo", catalog = "WaterFil")
public class UsersRoles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "Status_ID", nullable = false)
    private int statusId;
    @Basic
    @Column(name = "Description", nullable = true, length = 500)
    private String description;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getStatusId()
    {
        return statusId;
    }

    public void setStatusId(int statusId)
    {
        this.statusId = statusId;
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
    public int hashCode()
    {
        return Objects.hash(id, name, statusId, description);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersRoles that = (UsersRoles) o;
        return id == that.id && statusId == that.statusId && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }
}
