package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimekeepingdetailDTO {
    private String timeKeepingDetailId;
    private String employeeId;
    private Integer numberOfWorkingDays;
    private Integer numberOfDaysOff;
    private Integer numberOfDaysLate;
    private Integer workingMonth;
    private Integer workingYear;
    private LocalDateTime createdAt;

    public String getTimeKeepingDetailId() {
        return this.timeKeepingDetailId;
    }

    public void setTimeKeepingDetailId(String timeKeepingDetailId) {
        this.timeKeepingDetailId = timeKeepingDetailId;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getNumberOfWorkingDays() {
        return this.numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(Integer numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public Integer getNumberOfDaysOff() {
        return this.numberOfDaysOff;
    }

    public void setNumberOfDaysOff(Integer numberOfDaysOff) {
        this.numberOfDaysOff = numberOfDaysOff;
    }

    public Integer getNumberOfDaysLate() {
        return this.numberOfDaysLate;
    }

    public void setNumberOfDaysLate(Integer numberOfDaysLate) {
        this.numberOfDaysLate = numberOfDaysLate;
    }

    public Integer getWorkingMonth() {
        return this.workingMonth;
    }

    public void setWorkingMonth(Integer workingMonth) {
        this.workingMonth = workingMonth;
    }

    public Integer getWorkingYear() {
        return this.workingYear;
    }

    public void setWorkingYear(Integer workingYear) {
        this.workingYear = workingYear;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
