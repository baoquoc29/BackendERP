package com.example.vinasoy.controller.income;

import com.example.vinasoy.dto.income.RevenueDTO;
import com.example.vinasoy.response.ApiResponse;
import com.example.vinasoy.service.income.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/revenue")
public class RevenueController {
    @Autowired
    RevenueService revenueService;
    @GetMapping
    public ResponseEntity<?> getRevenue(@RequestParam(required = false) Integer month,@RequestParam(required = false) Integer year) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("OK");
        List<RevenueDTO> list = revenueService.getAllRevenue(month,year);
        apiResponse.setMessage("Revenue");
        apiResponse.setResult(list);
        return ResponseEntity.ok(apiResponse);
    }
}
