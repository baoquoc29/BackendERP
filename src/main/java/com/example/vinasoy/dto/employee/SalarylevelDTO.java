package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SalarylevelDTO {
    private String salaryLevelId;
    private String gradeId;
    private BigDecimal salaryLevelAmount;
    private String note;


}
