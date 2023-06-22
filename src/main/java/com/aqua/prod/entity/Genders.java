package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Genders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Status_ID")
    private int statusId;
    @Basic
    @Column(name = "Description")
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genders genders = (Genders) o;
        return id == genders.id && statusId == genders.statusId && Objects.equals(name, genders.name) && Objects.equals(description, genders.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, statusId, description);
    }
}
