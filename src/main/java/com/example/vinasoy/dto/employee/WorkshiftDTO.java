package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class WorkshiftDTO {
    private String workShiftId;
    private String shiftsType;
    private LocalTime checkIn;
    private LocalTime checkOut;


}
