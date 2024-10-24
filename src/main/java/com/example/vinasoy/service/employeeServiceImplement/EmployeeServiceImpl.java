package com.example.vinasoy.service.employeeServiceImplement;
import com.example.vinasoy.dto.employee.PositionDTO.PositionResponseDTO;
import com.example.vinasoy.dto.employee.departmentDTO.DepartmentResponseDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeRequestDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import com.example.vinasoy.entity.employee.*;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.*;
import com.example.vinasoy.service.employees.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryV1 employeeRepositoryV1;
    private final ModelMapper modelMapper;
    private final PositionsRepository positionsRepository;
    private final DepartmentRepository departmentRepository;
    private final ContractRepository contractRepository;
     private final RewarddisciplineRepository rewarddisciplineRepository;

    @Override
    public List<EmployeeResponseDTO> getAllInfoEmployee() {
        List<Employee> employees = employeeRepositoryV1.findAll();
        if (employees.isEmpty()) {
            throw new AppException(ErrorCode.NOT_FOUND);
        }
        return employees.stream().map(employee -> {
            EmployeeResponseDTO dto = modelMapper.map(employee, EmployeeResponseDTO.class);
            if (employee.getPositionID() != null) {
                PositionResponseDTO positionDto = modelMapper.map(employee.getPositionID(), PositionResponseDTO.class);
                dto.setPosition(positionDto);
            }
            if (employee.getDepartmentID() != null) {
                DepartmentResponseDTO departmentDto = modelMapper.map(employee.getDepartmentID(), DepartmentResponseDTO.class);
                dto.setDepartment(departmentDto);
            }
            return dto;
        }).collect(Collectors.toList());
    }



    @Override
    public EmployeeResponseDTO getEmployeeById(String id) {
        Employee employee = employeeRepositoryV1.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        EmployeeResponseDTO dto = modelMapper.map(employee, EmployeeResponseDTO.class);
        PositionResponseDTO positionDto = modelMapper.map(employee.getPositionID(), PositionResponseDTO.class);
        dto.setPosition(positionDto);

        // Ánh xạ phòng ban
        DepartmentResponseDTO departmentDto = modelMapper.map(employee.getDepartmentID(), DepartmentResponseDTO.class);
        dto.setDepartment(departmentDto);

        return dto;
    }

    @Override
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO updateDTO) {
        Employee employee = employeeRepositoryV1.findById(updateDTO.getEmployeeID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(updateDTO, employee);

        if (updateDTO.getPositionID() != null) {
            Position position = positionsRepository.findById(updateDTO.getPositionID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
            employee.setPositionID(position);
        }
        if (updateDTO.getDepartmentID() != null) {
            Department department = departmentRepository.findById(updateDTO.getDepartmentID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
            employee.setDepartmentID(department);
        }
        employeeRepositoryV1.save(employee);
        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Position position = null;
        Department department = null;
        Contract contract = null;

        if (employeeRequestDTO.getPositionID() != null) {
            position = positionsRepository.findById(employeeRequestDTO.getPositionID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        }
        if (employeeRequestDTO.getContractID() != null) {
            contract = contractRepository.findById(employeeRequestDTO.getContractID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        }

        if (employeeRequestDTO.getDepartmentID() != null) {
            department = departmentRepository.findById(employeeRequestDTO.getDepartmentID())
                    .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        }
        String newEmployeeId = generateEmployeeId();
        employeeRequestDTO.setEmployeeID(newEmployeeId);
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        employee.setPositionID(position);
        employee.setDepartmentID(department);
        employee.setContractID(contract);

        Employee savedEmployee = employeeRepositoryV1.save(employee);

        return modelMapper.map(savedEmployee, EmployeeResponseDTO.class);
    }

    @Override
    public List<EmployeeResponseDTO> searchEmployees(String keywords) {
        List<Employee> employees = employeeRepositoryV1.findByEmployeeNameContainingIgnoreCaseOrEmployeeIDContainingIgnoreCase(keywords, keywords);
        return employees.stream().map(employee -> {
            EmployeeResponseDTO dto = modelMapper.map(employee, EmployeeResponseDTO.class);
            if (employee.getPositionID() != null) {
                PositionResponseDTO positionDto = modelMapper.map(employee.getPositionID(), PositionResponseDTO.class);
                dto.setPosition(positionDto);
            }
            if (employee.getDepartmentID() != null) {
                DepartmentResponseDTO departmentDto = modelMapper.map(employee.getDepartmentID(), DepartmentResponseDTO.class);
                dto.setDepartment(departmentDto);
            }
            return dto;
        }).collect(Collectors.toList());
    }



    private String generateEmployeeId() {
        return employeeRepositoryV1.findAll()
                .stream()
                .map(Employee::getEmployeeID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("EMP-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("EMP-0001"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }


}
