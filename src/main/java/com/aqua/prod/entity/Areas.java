package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Areas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Governorate_ID")
    private int governorateId;
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

    public int getGovernorateId()
    {
        return governorateId;
    }

    public void setGovernorateId(int governorateId)
    {
        this.governorateId = governorateId;
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
        Areas areas = (Areas) o;
        return id == areas.id && governorateId == areas.governorateId && statusId == areas.statusId && Objects.equals(name, areas.name) && Objects.equals(description, areas.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, governorateId, statusId, description);
    }
}
