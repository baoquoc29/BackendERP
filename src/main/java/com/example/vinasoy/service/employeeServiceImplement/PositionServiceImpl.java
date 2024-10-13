package com.example.vinasoy.service.employeeServiceImplement;

import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.entity.employee.Position;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.PositionsRepository;
import com.example.vinasoy.service.employees.PositionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionsRepository positionsRepository;
    private final ModelMapper modelMapper;

    @Override
    public PositionsDTO createPosition(PositionsDTO positionsDTO) {
        String newPositionId = generatePositionId();
        positionsDTO.setPositionID(newPositionId);
        Position positions = modelMapper.map(positionsDTO, Position.class);
        Position savedPosition = positionsRepository.save(positions);
        return modelMapper.map(savedPosition, PositionsDTO.class);
    }

    @Override
    public List<PositionsDTO> getAllPositions() {
        return positionsRepository.findAll().stream()
                .map(position -> modelMapper.map(position, PositionsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PositionsDTO getPositionById(String id) {
        Position position = positionsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        return modelMapper.map(position, PositionsDTO.class);
    }

    @Override
    public List<PositionsDTO> searchPositions(String keyword) {
        List<Position> foundPositions = positionsRepository.findByPositionIDContainingIgnoreCaseOrNamePositionContainingIgnoreCase(keyword, keyword);
        return foundPositions.stream()
                .map(position -> modelMapper.map(position, PositionsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PositionsDTO updatePosition(PositionsDTO positionsDTO) {
        Position position = positionsRepository.findById(positionsDTO.getPositionID())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        modelMapper.map(positionsDTO, position);
        Position updatedPosition = positionsRepository.save(position);
        return modelMapper.map(updatedPosition, PositionsDTO.class);
    }

    @Override
    public void deletePosition(String id) {
        positionsRepository.deleteById(id);
    }

    private String generatePositionId() {
        return positionsRepository.findAll()
                .stream()
                .map(Position::getPositionID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("POS-%04d", currentNumber + 1); // Tạo ID mới
                })
                .orElse("POS-0001"); // Nếu không có dữ liệu, bắt đầu từ VTR-0001
    }
}
