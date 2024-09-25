package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "workshift")
public class Workshift {
    @Id
    @Column(name = "WorkShiftID", nullable = false, length = 10)
    private String workShiftID;

    @Column(name = "ShiftsType")
    private String shiftsType;

    @Column(name = "CheckIn")
    private LocalTime checkIn;

    @Column(name = "CheckOut")
    private LocalTime checkOut;

}