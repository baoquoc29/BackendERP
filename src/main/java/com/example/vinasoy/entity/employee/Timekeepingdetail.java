package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "timekeepingdetail")
public class Timekeepingdetail {
    @Id
    @Column(name = "TimeKeepingDetailID", nullable = false, length = 10)
    private String timeKeepingDetailID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "NumberOfWorkingDays")
    private Integer numberOfWorkingDays;

    @Column(name = "NumberOfDaysOff")
    private Integer numberOfDaysOff;

    @Column(name = "NumberOfDaysLate")
    private Integer numberOfDaysLate;

    @Column(name = "WorkingMonth")
    private Integer workingMonth;

    @Column(name = "WorkingYear")
    private Integer workingYear;

    @Column(name = "CreatedAt")
    private Instant createdAt;

}