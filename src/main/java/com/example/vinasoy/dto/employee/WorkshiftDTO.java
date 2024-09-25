package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkshiftDTO {
    private String workShiftId;
    private String shiftsType;
    private LocalDate checkIn;
    private LocalDate checkOut;


}
