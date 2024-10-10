package com.example.vinasoy.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkshiftDTO {
    private String workShiftId;
    private String shiftsType;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

}
