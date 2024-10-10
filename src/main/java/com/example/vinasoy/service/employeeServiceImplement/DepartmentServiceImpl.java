package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.DepartmentRepository;
import com.example.vinasoy.service.employees.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        String newDepartmentId = generateDepartmentId();
        departmentDTO.setDepartmentID(newDepartmentId);
        Department department = modelMapper.map(departmentDTO, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(String id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        return modelMapper.map(department, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(departmentDTO.getDepartmentID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));

        existingDepartment.setNameDepartment(departmentDTO.getNameDepartment());
        existingDepartment.setAddressDepartment(departmentDTO.getAddressDepartment());
        existingDepartment.setPhoneDepartment(departmentDTO.getPhoneDepartment());

        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return modelMapper.map(updatedDepartment, DepartmentDTO.class);
    }

    @Override
    public void deleteDepartment(String id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        departmentRepository.delete(department);
    }

    private String generateDepartmentId() {
        return departmentRepository.findAll()
                .stream()
                .map(Department::getDepartmentID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("DPM<-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("DPM-0001"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }

}
