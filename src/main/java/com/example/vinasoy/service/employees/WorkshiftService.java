package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.WorkshiftDTO;

import java.util.List;

public interface WorkshiftService {
    List<WorkshiftDTO> getAllWorkshifts();
    WorkshiftDTO getWorkshiftById(String id);
    WorkshiftDTO createWorkshift(WorkshiftDTO workshiftDTO);
    WorkshiftDTO updateWorkshift(WorkshiftDTO workshiftDTO);
    void deleteWorkshift(String id);
}
