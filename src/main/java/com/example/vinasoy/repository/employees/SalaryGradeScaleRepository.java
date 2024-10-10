package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Salarygradescale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryGradeScaleRepository extends JpaRepository<Salarygradescale,String> {
    List<Salarygradescale> findBySalaryGradeNameContainingIgnoreCaseOrSalaryScaleContainingIgnoreCase(String gradeName, String scale);
}
