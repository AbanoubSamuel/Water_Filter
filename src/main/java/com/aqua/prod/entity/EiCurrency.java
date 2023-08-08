package com.aqua.prod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "EI_Currencies")
public class EiCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Code", length = 100)
    private String code;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "EnglishDesc", length = 1000)
    private String englishDesc;

}