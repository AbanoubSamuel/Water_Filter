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
@Table(name = "Currencies")
public class Currency {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Name", length = 100)
    private String name;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Native_Language_Name", length = 100)
    private String nativeLanguageName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EI_Currency_ID")
    private EiCurrency eiCurrency;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

}