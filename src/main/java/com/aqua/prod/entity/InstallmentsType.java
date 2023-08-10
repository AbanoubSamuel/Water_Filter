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
@Table(name = "Installments_Types")
public class InstallmentsType {
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Payment_Type_ID", nullable = false)
    private PaymentType paymentType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Down_Payment_Amount_Type_ID", nullable = false)
    private AmountType downPaymentAmountType;

    @NotNull
    @Column(name = "Down_Payment_Amount", nullable = false)
    private Double downPaymentAmount;

    @NotNull
    @Column(name = "NB_Of_Instalments", nullable = false)
    private Integer nbOfInstalments;

    @NotNull
    @Column(name = "Monthly_Interest_Percent", nullable = false)
    private Double monthlyInterestPercent;

    @NotNull
    @Column(name = "Yearly_Interest_Percent", nullable = false)
    private Double yearlyInterestPercent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Status_ID", nullable = false)
    private Status status;

    @Size(max = 1000)
    @Nationalized
    @Column(name = "Remarks", length = 1000)
    private String remarks;

}