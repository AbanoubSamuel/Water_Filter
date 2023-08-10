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
@Table(name = "Statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 200)
    private String name;

    @NotNull
    @Column(name = "Is_Active", nullable = false)
    private Boolean isActive = false;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Description", length = 1000)
    private String description;

}