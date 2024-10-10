package com.example.vinasoy.dto.employee.RewardDisciplineDTO;

import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RewardDisciplineRequestDTO {
    private String rewardDisciplineId;
    private String form;
    private String employeeID;
    private String decisionNumber;
    private LocalDate decisionDate;
    private String reason;
    private String signer;
}
