package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.PositionsDTO;

import java.util.List;

public interface PositionService {
    public PositionsDTO createPosition(PositionsDTO positionsDTO);
    public List<PositionsDTO> getAllPositions();
    public PositionsDTO getPositionById(String id);
    public PositionsDTO updatePosition(PositionsDTO positionsDTO);
    public void deletePosition(String id);
    List<PositionsDTO> searchPositions(String keyword);;
}
