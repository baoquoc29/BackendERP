package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class WorkshiftDTO {
    private String workShiftId;
    private String shiftsType;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

}
