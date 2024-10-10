package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.WorkshiftDTO;
import com.example.vinasoy.entity.employee.Workshift;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.WorkshiftRepository;
import com.example.vinasoy.service.employees.WorkshiftService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkshiftServiceImpl implements WorkshiftService {
    private final WorkshiftRepository workshiftRepository;
    private final ModelMapper modelMapper;

    @Override
    public WorkshiftDTO createWorkshift(WorkshiftDTO workshiftDTO) {
        String newWorkshiftId = generateWorkshiftId();
        workshiftDTO.setWorkShiftId(newWorkshiftId);

        Workshift workshift = modelMapper.map(workshiftDTO, Workshift.class);
        Workshift savedWorkshift = workshiftRepository.save(workshift);
        return modelMapper.map(savedWorkshift, WorkshiftDTO.class);
    }

    @Override
    public List<WorkshiftDTO> getAllWorkshifts() {
        return workshiftRepository.findAll().stream()
                .map(workshift -> modelMapper.map(workshift, WorkshiftDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public WorkshiftDTO getWorkshiftById(String id) {
        Workshift workshift = workshiftRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        return modelMapper.map(workshift, WorkshiftDTO.class);
    }

    @Override
    public WorkshiftDTO updateWorkshift(WorkshiftDTO workshiftDTO) {
        Workshift workshift = workshiftRepository.findById(workshiftDTO.getWorkShiftId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(workshiftDTO, workshift);
        Workshift updatedWorkshift = workshiftRepository.save(workshift);
        return modelMapper.map(updatedWorkshift, WorkshiftDTO.class);
    }

    @Override
    public void deleteWorkshift(String id) {
        workshiftRepository.deleteById(id);
    }

    private String generateWorkshiftId() {
        return workshiftRepository.findAll()
                .stream()
                .map(Workshift::getWorkShiftID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("WS-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("WS-0001"); // Nếu không có ca làm việc nào, bắt đầu từ WS-0001
    }
}
