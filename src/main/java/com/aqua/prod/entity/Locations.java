package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Locations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Area_ID")
    private int areaId;
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

    public int getAreaId()
    {
        return areaId;
    }

    public void setAreaId(int areaId)
    {
        this.areaId = areaId;
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
        Locations locations = (Locations) o;
        return id == locations.id && areaId == locations.areaId && statusId == locations.statusId && Objects.equals(name, locations.name) && Objects.equals(description, locations.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, areaId, statusId, description);
    }
}
