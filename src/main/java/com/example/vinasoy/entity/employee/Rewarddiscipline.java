package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "rewarddiscipline")
public class Rewarddiscipline {
    @Id
    @Size(max = 10)
    @Column(name = "RewardDisciplineID", nullable = false, length = 10)
    private String rewardDisciplineID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Size(max = 100)
    @Column(name = "Form", length = 100)
    private String form;

    @Size(max = 100)
    @Column(name = "DecisionNumber", length = 100)
    private String decisionNumber;

    @Column(name = "DecisionDate")
    private LocalDate decisionDate;

    @Size(max = 255)
    @Column(name = "Reason")
    private String reason;

    @Size(max = 100)
    @Column(name = "Signer", length = 100)
    private String signer;

}