package com.example.vinasoy.repository.employees;

import com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO;
import com.example.vinasoy.entity.employee.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {

    @Query("SELECT new com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO(c.contractID, e.employeeName, d.nameDepartment, p.namePosition, c.salaryContract, c.startDate, c.endDate, c.contractStatus) " +
            "FROM Contract c " +
            "JOIN Employee e ON e.contractID.contractID = c.contractID " +
            "JOIN e.departmentID d " +
            "JOIN e.positionID p")
    List<ContractDetailResponseDTO> findAllContractDTOs();

    @Query("SELECT new com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO(c.contractID, e.employeeName, d.nameDepartment, p.namePosition, c.salaryContract, c.startDate, c.endDate, c.contractStatus) " +
            "FROM Contract c " +
            "JOIN Employee e ON e.contractID.contractID = c.contractID " +
            "JOIN e.departmentID d " +
            "JOIN e.positionID p " +
            "WHERE d.nameDepartment LIKE %:keywords% " +
            "OR e.employeeName LIKE %:keywords% " +
            "OR p.namePosition LIKE %:keywords% " +
            "OR c.contractStatus LIKE %:keywords%")
    List<ContractDetailResponseDTO> findContractsByKeywords(@Param("keywords") String keywords);

}
