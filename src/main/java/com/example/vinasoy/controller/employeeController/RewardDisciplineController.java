package com.example.vinasoy.controller.employeeController;

import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineRequestDTO;
import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineResponseDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.RewarddisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reward-disciplines")
public class RewardDisciplineController {

    private final RewarddisciplineService rewarddisciplineService;

    public RewardDisciplineController(RewarddisciplineService rewarddisciplineService) {
        this.rewarddisciplineService = rewarddisciplineService;
    }

    @PostMapping
    public ResponseEntity<?> createRewardDiscipline(@RequestBody RewardDisciplineResponseDTO rewardDisciplineResponseDTO) {
        RewardDisciplineResponseDTO createdRewardDiscipline = rewarddisciplineService.createRewardDiscipline(rewardDisciplineResponseDTO);
        ApiResponse<RewardDisciplineResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdRewardDiscipline);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllRewardDisciplines() {
        List<RewardDisciplineResponseDTO> rewardDisciplines = rewarddisciplineService.getAllRewardDisciplines();
        ApiResponse<List<RewardDisciplineResponseDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(rewardDisciplines);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getRewardDisciplineById(@PathVariable String id) {
        RewardDisciplineResponseDTO rewardDisciplineResponseDTO = rewarddisciplineService.getRewardDisciplineById(id);
        ApiResponse<RewardDisciplineResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(rewardDisciplineResponseDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping
    public ResponseEntity<?> updateRewardDiscipline(@RequestBody RewardDisciplineRequestDTO rewardDisciplineRequestDTO) {
        RewardDisciplineResponseDTO updatedRewardDiscipline = rewarddisciplineService.updateRewardDiscipline(rewardDisciplineRequestDTO);
        ApiResponse<RewardDisciplineResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedRewardDiscipline);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRewardDiscipline(@PathVariable String id) {
        rewarddisciplineService.deleteRewardDiscipline(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Reward discipline deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
