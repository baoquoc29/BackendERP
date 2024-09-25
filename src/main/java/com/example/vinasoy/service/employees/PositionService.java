package com.example.vinasoy.service.employees;
import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.entity.employee.Position;

import java.util.List;

public interface PositionService {

    public void createPosition(PositionsDTO positionsDTO);

    public void deletePosition(String departmentId);

    public void updatePosition(PositionsDTO positionsDTO);

    public List<PositionsDTO> getAllPositions();
    public PositionsDTO getPositionById(String departmentId);

}

