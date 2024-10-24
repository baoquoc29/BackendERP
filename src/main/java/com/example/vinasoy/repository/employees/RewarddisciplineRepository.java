package com.example.vinasoy.repository.employees;

import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineResponseDTO;
import com.example.vinasoy.entity.employee.Rewarddiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RewarddisciplineRepository extends JpaRepository<Rewarddiscipline,String> {
    List<Rewarddiscipline> findByEmployeeID_EmployeeID(String employeeID);
}
