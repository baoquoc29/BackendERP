package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimekeepingdataDTO {
    private String timeKeepingDataId;
    private String employeeId;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private Integer timeRecorder;


}
