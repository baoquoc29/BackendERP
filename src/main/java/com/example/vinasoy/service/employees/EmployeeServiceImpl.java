package com.example.vinasoy.service.employees;
import com.example.vinasoy.dto.employee.*;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.repository.employees.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return convertToDTO(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);

        if (employee.getPosition() != null) {
            PositionsDTO positionDTO = modelMapper.map(employee.getPosition(), PositionsDTO.class);

            if (employee.getPosition().getAllowance() != null) {
                AllowanceDTO allowanceDTO = modelMapper.map(employee.getPosition().getAllowance(), AllowanceDTO.class);
                positionDTO.setAllowance(allowanceDTO);
            }
            dto.setPosition(positionDTO);
        }
        if (employee.getDepartment() != null) {
            DepartmentDTO departmentDTO = modelMapper.map(employee.getDepartment(), DepartmentDTO.class);
            dto.setDepartment(departmentDTO);
        }
        if (employee.getWorkshift() != null) {
            WorkshiftDTO workshiftDTO = modelMapper.map(employee.getWorkshift(), WorkshiftDTO.class);
            dto.setWorkShift(workshiftDTO);
        }

        return dto;
    }
}
