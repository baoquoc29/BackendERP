package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineRequestDTO;
import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineResponseDTO;

import java.util.List;

public interface RewarddisciplineService {
    public RewardDisciplineResponseDTO createRewardDiscipline(RewardDisciplineResponseDTO rewardDisciplineResponseDTO);
    public List<RewardDisciplineResponseDTO> getAllRewardDisciplines();
    public RewardDisciplineResponseDTO getRewardDisciplineById(String id);
    public RewardDisciplineResponseDTO updateRewardDiscipline(RewardDisciplineRequestDTO rewardDisciplineRequestDTO);
    public void deleteRewardDiscipline(String id);
    public List<RewardDisciplineResponseDTO> findRewardDisciplineByEmployeeId(String employeeId);
}
