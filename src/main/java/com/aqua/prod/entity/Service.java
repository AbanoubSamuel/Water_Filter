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
@Table(name = "Services")
public class Service {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 500)
    @NotNull
    @Nationalized
    @Column(name = "Name", nullable = false, length = 500)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Size(max = 500)
    @Nationalized
    @Column(name = "Description", length = 500)
    private String description;

}