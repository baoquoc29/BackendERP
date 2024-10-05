package com.example.vinasoy.dto.employee;

import lombok.Data;

@Data
public class AttendancerecordDTO {
    private String attendanceRecordId;
    private String employeeId;
    private Integer numberOfWorkingDays;
    private Integer numberOfDaysOff;
    private Integer numberOfDaysLate;
    private Integer workMonth;
    private Integer workYear;

}
