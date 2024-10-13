package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractRequestDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractResponseDTO;

import java.util.List;

public interface ContractService {
    public List<ContractDetailResponseDTO> getAllContracts();
    public ContractResponseDTO getContractById(String id);
    public ContractDetailResponseDTO createContract(ContractRequestDTO contractDTO);
    public void updateContract(ContractRequestDTO contractResponseDTO);
    public List<ContractDetailResponseDTO> searchContracts(String keywords);
}
