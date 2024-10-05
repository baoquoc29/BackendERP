package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "socialinsurance")
public class Socialinsurance {
    @Id
    @Size(max = 10)
    @Column(name = "SocialInsuranceID", nullable = false, length = 10)
    private String socialInsuranceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Size(max = 100)
    @Column(name = "InsuranceNumber", length = 100)
    private String insuranceNumber;

    @Column(name = "IssueDate")
    private LocalDate issueDate;

    @Column(name = "ExpirationDate")
    private LocalDate expirationDate;

    @Size(max = 100)
    @Column(name = "IssuePlace", length = 100)
    private String issuePlace;

    @Size(max = 100)
    @Column(name = "HealthFacility", length = 100)
    private String healthFacility;

}