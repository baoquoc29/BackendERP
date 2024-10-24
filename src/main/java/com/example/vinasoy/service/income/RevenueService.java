package com.example.vinasoy.service.income;

import com.example.vinasoy.dto.income.RevenueDTO;

import java.util.List;

public interface RevenueService {
    List<RevenueDTO> getAllRevenue(Integer month,Integer year);
}
