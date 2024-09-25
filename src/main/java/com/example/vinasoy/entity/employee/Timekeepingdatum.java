package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "timekeepingdata")
public class Timekeepingdatum {
    @Id
    @Column(name = "TimeKeepingDataID", nullable = false, length = 10)
    private String timeKeepingDataID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "TimeIn")
    private Instant timeIn;

    @Column(name = "TimeOut")
    private Instant timeOut;

    @Column(name = "TimeRecorder")
    private Integer timeRecorder;

}