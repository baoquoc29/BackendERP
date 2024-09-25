package com.example.vinasoy.service.employees;
import com.example.vinasoy.dto.employee.DepartmentDTO;
import com.example.vinasoy.dto.exception.AppException;
import com.example.vinasoy.dto.exception.ErrorCode;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.repository.employees.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentsById(String departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_FOUND));
        return modelMapper.map(department, DepartmentDTO.class);
    }


    @Override
    public void createDepartment(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be null or empty");
        } else if (departmentRepository.existsByNameDepartment(departmentName)) {
            throw new AppException(ErrorCode.DEPARTMENT_NAME_EXISTED);
        }
        String departmentId = generateDepartmentId();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentId(departmentId);
        departmentDTO.setNameDepartment(departmentName);
        Department newDepartment = modelMapper.map(departmentDTO, Department.class);
        departmentRepository.save(newDepartment);
    }


    @Override
    @Transactional
    public void deleteDepartment(String departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new EntityNotFoundException("Department not found with ID: " + departmentId);
        }
    }

    @Override
    @Transactional
    public void updateDepartment(String departmentId, String newDepartmentName) {
        if (newDepartmentName == null) {
            throw new IllegalArgumentException("newDepartmentName must not be null");
        }
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + departmentId));
        department.setNameDepartment(newDepartmentName);
        departmentRepository.save(department);
    }

    private String generateDepartmentId() {
        return departmentRepository.findAll()
                .stream()
                .map(Department::getDepartmentID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("DPM-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("DPM-0001");
    }

}
