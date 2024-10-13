package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.SalaryGradeScaleDTO;
import com.example.vinasoy.entity.employee.Salarygradescale;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.SalaryGradeScaleRepository;
import com.example.vinasoy.service.employees.SalarygradescaleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SalarygradescaleServiceImpl implements SalarygradescaleService {
    private final SalaryGradeScaleRepository salaryGradeScaleRepository;
    private final ModelMapper modelMapper;

    @Override
    public SalaryGradeScaleDTO createSalaryGradeScale(SalaryGradeScaleDTO salaryGradeScaleDTO) {
        String newSalaryGradeScaleId = generateSalaryGradeScaleId();
        salaryGradeScaleDTO.setSalaryGradeScaleId(newSalaryGradeScaleId);
        Salarygradescale salaryGradeScale = modelMapper.map(salaryGradeScaleDTO, Salarygradescale.class);
        Salarygradescale savedSalaryGradeScale = salaryGradeScaleRepository.save(salaryGradeScale);
        return modelMapper.map(savedSalaryGradeScale, SalaryGradeScaleDTO.class);
    }

    @Override
    public List<SalaryGradeScaleDTO> getAllSalaryGradeScales() {
        return salaryGradeScaleRepository.findAll()
                .stream()
                .map(salaryGradeScale -> modelMapper.map(salaryGradeScale, SalaryGradeScaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SalaryGradeScaleDTO getSalaryGradeScaleById(String id) {
        Salarygradescale salaryGradeScale = salaryGradeScaleRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        return modelMapper.map(salaryGradeScale, SalaryGradeScaleDTO.class);
    }

    @Override
    public SalaryGradeScaleDTO updateSalaryGradeScale(SalaryGradeScaleDTO salaryGradeScaleDTO) {
        Salarygradescale existingSalaryGradeScale = salaryGradeScaleRepository.findById(salaryGradeScaleDTO.getSalaryGradeScaleId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        existingSalaryGradeScale.setSalaryScale(salaryGradeScaleDTO.getSalaryScale());
        existingSalaryGradeScale.setSalaryGradeName(salaryGradeScaleDTO.getSalaryGradeName());
        existingSalaryGradeScale.setSalaryAmount(salaryGradeScaleDTO.getSalaryAmount());
        existingSalaryGradeScale.setStatus(salaryGradeScaleDTO.getStatus());

        Salarygradescale updatedSalaryGradeScale = salaryGradeScaleRepository.save(existingSalaryGradeScale);
        return modelMapper.map(updatedSalaryGradeScale, SalaryGradeScaleDTO.class);
    }

    @Override
    public void deleteSalaryGradeScale(String id) {
        Salarygradescale salaryGradeScale = salaryGradeScaleRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        salaryGradeScaleRepository.delete(salaryGradeScale);
    }

    @Override
    public List<SalaryGradeScaleDTO> searchSalaryGradeScales(String keywords) {
        List<Salarygradescale> salaryGradeScales = salaryGradeScaleRepository.findBySalaryGradeNameContainingIgnoreCaseOrSalaryScaleContainingIgnoreCase(keywords, keywords);
        return salaryGradeScales.stream()
                .map(salaryGradeScale -> modelMapper.map(salaryGradeScale, SalaryGradeScaleDTO.class))
                .collect(Collectors.toList());
    }

    private String generateSalaryGradeScaleId() {
        return salaryGradeScaleRepository.findAll()
                .stream()
                .map(Salarygradescale::getSalaryGradeScaleID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("SGS<-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("SGS-0001"); // Nếu không có SalaryGradeScale nào, bắt đầu từ SGS-0001
    }

}
