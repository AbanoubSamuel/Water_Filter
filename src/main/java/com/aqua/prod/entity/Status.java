package com.aqua.prod.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Statuses")
public class Status {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Column(name = "Is_Active", nullable = false)
    private Boolean isActive = false;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Description", length = 500)
    private String description;

}