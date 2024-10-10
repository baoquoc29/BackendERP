package com.example.vinasoy.controller;
import com.example.vinasoy.dto.employee.socialinsuranceDTO.SocialinsuranceDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.employees.SocialinsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/socialinsurances")
public class SocialinsuranceController {

    private final SocialinsuranceService socialinsuranceService;

    public SocialinsuranceController(SocialinsuranceService socialinsuranceService) {
        this.socialinsuranceService = socialinsuranceService;
    }

    @PostMapping
    public ResponseEntity<?> createSocialInsurance(@RequestBody SocialinsuranceDTO socialinsuranceDTO) {
        SocialinsuranceDTO createdSocialInsurance = socialinsuranceService.createSocialinsurance(socialinsuranceDTO);
        ApiResponse<SocialinsuranceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(createdSocialInsurance);
        apiResponse.setCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllSocialInsurances() {
        List<SocialinsuranceDTO> socialInsurances = socialinsuranceService.getAllSocialinsurances();
        ApiResponse<List<SocialinsuranceDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(socialInsurances);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSocialInsuranceById(@PathVariable String id) {
        SocialinsuranceDTO socialinsuranceDTO = socialinsuranceService.getSocialinsuranceById(id);
        ApiResponse<SocialinsuranceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(socialinsuranceDTO);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSocialInsurance(@PathVariable String id,
                                                   @RequestBody SocialinsuranceDTO socialinsuranceDTO) {
        socialinsuranceDTO.setSocialInsuranceID(id); // Set ID từ đường dẫn
        SocialinsuranceDTO updatedSocialInsurance = socialinsuranceService.updateSocialinsurance(socialinsuranceDTO);
        ApiResponse<SocialinsuranceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(updatedSocialInsurance);
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSocialInsurance(@PathVariable String id) {
        socialinsuranceService.deleteSocialinsurance(id);
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Social insurance deleted successfully.");
        apiResponse.setCode(HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
