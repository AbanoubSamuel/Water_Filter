package com.aqua.prod.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Statuses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "Is_Active", nullable = false)
    private boolean isActive;
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

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
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
        return Objects.hash(id, name, isActive, description);
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Statuses statuses = (Statuses) object;
        return id == statuses.id && isActive == statuses.isActive && Objects.equals(name, statuses.name) && Objects.equals(description, statuses.description);
    }
}
