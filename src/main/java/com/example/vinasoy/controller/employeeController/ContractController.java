package com.example.vinasoy.controller.employeeController;
import com.example.vinasoy.dto.employee.contractDTO.ContractResponseDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractRequestDTO;
import com.example.vinasoy.dto.employee.contractDTO.ContractDetailResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<?> getAllContracts() {
        List<ContractDetailResponseDTO> contracts = contractService.getAllContracts();
        ApiResponse<List<ContractDetailResponseDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contracts);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContractById(@PathVariable String id) {
        ContractResponseDTO contractDTO = contractService.getContractById(id);
        ApiResponse<ContractResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contractDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> createContract(@RequestBody ContractRequestDTO contractRequestDTO) {
        ContractDetailResponseDTO createdContract = contractService.createContract(contractRequestDTO);
        ApiResponse<ContractDetailResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdContract);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchContracts(@RequestParam String keywords) {
        List<ContractDetailResponseDTO> contracts = contractService.searchContracts(keywords);
        ApiResponse<List<ContractDetailResponseDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contracts);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


    @PutMapping()
    public ResponseEntity<?> updateContract( @RequestBody ContractRequestDTO contractRequestDTO) {
        contractService.updateContract(contractRequestDTO);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Contract updated successfully");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


}
