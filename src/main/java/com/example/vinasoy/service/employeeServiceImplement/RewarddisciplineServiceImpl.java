package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.PositionDTO.PositionResponseDTO;
import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineRequestDTO;
import com.example.vinasoy.dto.employee.RewardDisciplineDTO.RewardDisciplineResponseDTO;
import com.example.vinasoy.dto.employee.departmentDTO.DepartmentResponseDTO;
import com.example.vinasoy.dto.employee.employeeDTO.EmployeeResponseDTO;
import com.example.vinasoy.entity.employee.Department;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.employee.Position;
import com.example.vinasoy.entity.employee.Rewarddiscipline;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.RewarddisciplineRepository;
import com.example.vinasoy.service.employees.RewarddisciplineService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RewarddisciplineServiceImpl implements RewarddisciplineService {
    private final RewarddisciplineRepository rewardDisciplineRepository;
    private final ModelMapper modelMapper;

    @Override
    public RewardDisciplineResponseDTO createRewardDiscipline(RewardDisciplineResponseDTO rewardDisciplineResponseDTO) {
        String newRewardDisciplineId = generateRewardDisciplineId();
        rewardDisciplineResponseDTO.setRewardDisciplineId(newRewardDisciplineId);
        String newDecisionNumber =generateRewardDisciplineDecisionNumber();
        rewardDisciplineResponseDTO.setDecisionNumber(newDecisionNumber);


        Rewarddiscipline rewardDiscipline = modelMapper.map(rewardDisciplineResponseDTO, Rewarddiscipline.class);
        Rewarddiscipline savedRewardDiscipline = rewardDisciplineRepository.save(rewardDiscipline);
        return modelMapper.map(savedRewardDiscipline, RewardDisciplineResponseDTO.class);
    }

    @Override
    public List<RewardDisciplineResponseDTO> getAllRewardDisciplines() {
        return rewardDisciplineRepository.findAll().stream()
                .map(rewardDiscipline -> {

                    RewardDisciplineResponseDTO dto = modelMapper.map(rewardDiscipline, RewardDisciplineResponseDTO.class);

                    Employee employee = rewardDiscipline.getEmployeeID();
                    Department department=employee.getDepartmentID();
                    Position position=employee.getPositionID();
                    DepartmentResponseDTO departmentDTO=modelMapper.map(department, DepartmentResponseDTO.class);
                    PositionResponseDTO positionResponseDTO=modelMapper.map(position,PositionResponseDTO.class);
                    if (employee != null) {
                        EmployeeResponseDTO employeeDTO = modelMapper.map(employee, EmployeeResponseDTO.class);
                        dto.setEmployeeResponseDTO(employeeDTO);
                        employeeDTO.setDepartment(departmentDTO);
                        employeeDTO.setPosition(positionResponseDTO);
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public RewardDisciplineResponseDTO getRewardDisciplineById(String id) {
        // Tìm phần tử theo ID
        Rewarddiscipline rewardDiscipline = rewardDisciplineRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        RewardDisciplineResponseDTO dto = modelMapper.map(rewardDiscipline, RewardDisciplineResponseDTO.class);

        Employee employee = rewardDiscipline.getEmployeeID();
        Department department = employee.getDepartmentID();
        Position position = employee.getPositionID();

        DepartmentResponseDTO departmentDTO = modelMapper.map(department, DepartmentResponseDTO.class);
        PositionResponseDTO positionResponseDTO = modelMapper.map(position, PositionResponseDTO.class);

        if (employee != null) {
            EmployeeResponseDTO employeeDTO = modelMapper.map(employee, EmployeeResponseDTO.class);
            dto.setEmployeeResponseDTO(employeeDTO);
            employeeDTO.setDepartment(departmentDTO);
            employeeDTO.setPosition(positionResponseDTO);
        }

        return dto;
    }



    @Override
    public RewardDisciplineResponseDTO updateRewardDiscipline(RewardDisciplineRequestDTO rewardDisciplineRequestDTO) {
        Rewarddiscipline rewardDiscipline = rewardDisciplineRepository.findById(rewardDisciplineRequestDTO.getRewardDisciplineId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(rewardDisciplineRequestDTO, rewardDiscipline);
        Rewarddiscipline updatedRewardDiscipline = rewardDisciplineRepository.save(rewardDiscipline);
        return modelMapper.map(updatedRewardDiscipline, RewardDisciplineResponseDTO.class);
    }

    @Override
    public void deleteRewardDiscipline(String id) {
        rewardDisciplineRepository.deleteById(id);
    }

    private String generateRewardDisciplineId() {
        return rewardDisciplineRepository.findAll()
                .stream()
                .map(Rewarddiscipline::getRewardDisciplineID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("RD<-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("RD-0001"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }

    private String generateRewardDisciplineDecisionNumber() {
        return rewardDisciplineRepository.findAll()
                .stream()
                .map(Rewarddiscipline::getDecisionNumber)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("Số<-%01d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("Số-01"); // Nếu không có nhân viên nào, bắt đầu từ EMP-0001
    }


}
