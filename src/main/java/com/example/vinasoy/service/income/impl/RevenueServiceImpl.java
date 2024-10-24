package com.example.vinasoy.service.income.impl;

import com.example.vinasoy.dto.income.RevenueDTO;
import com.example.vinasoy.repository.income.RevenueRepository;
import com.example.vinasoy.service.income.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RevenueServiceImpl implements RevenueService {
    @Autowired
    RevenueRepository repo;
    @Override
    public List<RevenueDTO> getAllRevenue(Integer month, Integer year) {
        return repo.getRevenue(month,year);
    }
}
