package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attendancerecord")
public class Attendancerecord {
    @Id
    @Size(max = 10)
    @Column(name = "AttendanceRecordID", nullable = false, length = 10)
    private String attendanceRecordID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "NumberOfWorkingDays")
    private Integer numberOfWorkingDays;

    @Column(name = "NumberOfDaysOff")
    private Integer numberOfDaysOff;

    @Column(name = "NumberOfDaysLate")
    private Integer numberOfDaysLate;

    @Column(name = "WorkMonth")
    private Integer workMonth;

    @Column(name = "WorkYear")
    private Integer workYear;

}