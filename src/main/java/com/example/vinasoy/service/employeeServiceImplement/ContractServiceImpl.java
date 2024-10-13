package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractRequestDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractResponseDTO;
import com.example.vinasoy.entity.employee.Contract;
import com.example.vinasoy.entity.employee.Salarygradescale;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.ContractRepository;
import com.example.vinasoy.repository.employees.SalaryGradeScaleRepository;
import com.example.vinasoy.service.employees.ContractService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final SalaryGradeScaleRepository salaryGradeScaleRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ContractDetailResponseDTO> getAllContracts() {
        return contractRepository.findAllContractDTOs();
    }

    @Override
    public List<ContractDetailResponseDTO> searchContracts(String keywords) {
        return contractRepository.findContractsByKeywords(keywords);
    }

    @Override
    public ContractResponseDTO getContractById(String id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        String salaryId = contract.getSalaryGradeScaleID() != null ?
                contract.getSalaryGradeScaleID().getSalaryGradeScaleID() : null;

        ContractResponseDTO contractResponseDTO = modelMapper.map(contract, ContractResponseDTO.class);

        contractResponseDTO.setSalaryGradeScaleID(salaryId);

        return contractResponseDTO;
    }


    @Override
    public ContractDetailResponseDTO createContract(ContractRequestDTO contractDTO) {
        String contractId = generateContractId();
        contractDTO.setContractID(contractId);
        Contract contract = modelMapper.map(contractDTO, Contract.class);

        // Kiểm tra SalaryGradeScaleID có tồn tại không
        if (contractDTO.getSalaryGradeScaleID() != null) {
            Salarygradescale salaryGradeScale = salaryGradeScaleRepository.findById(contractDTO.getSalaryGradeScaleID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
            contract.setSalaryGradeScaleID(salaryGradeScale);
        }

        Contract savedContract = contractRepository.save(contract);

        return modelMapper.map(savedContract, ContractDetailResponseDTO.class);
    }

    public void updateContract(ContractRequestDTO contractResponseDTO) {
        // Kiểm tra contractID có giá trị null không
        if (contractResponseDTO.getContractID() == null || contractResponseDTO.getContractID().isEmpty()) {
            throw new AppException(ErrorCode.NOT_FOUND_ID_CONTRACT);
        }

        // Tìm hợp đồng theo contractID
        Contract contract = contractRepository.findById(contractResponseDTO.getContractID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        // Kiểm tra SalaryGradeScaleID có giá trị null không
        if (contractResponseDTO.getSalaryGradeScaleID() == null || contractResponseDTO.getSalaryGradeScaleID().isEmpty()) {
            throw new AppException(ErrorCode.NOT_FOUND_ID_SALARY);
        }

        // Tìm SalaryGradeScale theo SalaryGradeScaleID
        Salarygradescale salaryGradeScale = salaryGradeScaleRepository.findById(contractResponseDTO.getSalaryGradeScaleID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        // Cập nhật hợp đồng
        modelMapper.map(contractResponseDTO, contract);
        contract.setSalaryGradeScaleID(salaryGradeScale);

        // Lưu hợp đồng đã cập nhật
        contractRepository.save(contract);
    }


    private String generateContractId() {
        return contractRepository.findAll()
                .stream()
                .map(Contract::getContractID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("HD-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("HD-0001"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }

}
