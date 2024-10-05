package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.time.LocalDate;
@Data
public class RewarddisciplineDTO {
    private String rewardDisciplineId;
    private String employeeId;
    private String form;
    private String decisionNumber;
    private LocalDate decisionDate;
    private String reason;
    private String signer;

}
