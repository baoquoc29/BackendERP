package com.example.vinasoy.service.employees;

import com.example.vinasoy.dto.employee.SalaryGradeScaleDTO;

import java.util.List;

public interface SalarygradescaleService{
    public SalaryGradeScaleDTO createSalaryGradeScale(SalaryGradeScaleDTO salaryGradeScaleDTO);
    public List<SalaryGradeScaleDTO> getAllSalaryGradeScales();
    public SalaryGradeScaleDTO getSalaryGradeScaleById(String id);
    public SalaryGradeScaleDTO updateSalaryGradeScale(SalaryGradeScaleDTO salaryGradeScaleDTO);
    public void deleteSalaryGradeScale(String id);
    public List<SalaryGradeScaleDTO> searchSalaryGradeScales(String keywords);
}
