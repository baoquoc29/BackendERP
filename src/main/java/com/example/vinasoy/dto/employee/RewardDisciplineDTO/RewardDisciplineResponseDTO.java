package com.example.vinasoy.dto.employee.RewardDisciplineDTO;

import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDisciplineResponseDTO {
    private String rewardDisciplineId;
    private String form;
    private EmployeeResponseDTO employeeResponseDTO;
    private String decisionNumber;
    private LocalDate decisionDate;
    private String reason;
    private String signer;

}
