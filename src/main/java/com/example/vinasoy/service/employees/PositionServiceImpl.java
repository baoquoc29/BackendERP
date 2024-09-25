package com.example.vinasoy.service.employees;
import com.example.vinasoy.dto.employee.PositionsDTO;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.entity.employee.Allowance;
import com.example.vinasoy.entity.employee.Position;
import com.example.vinasoy.repository.employees.AllowanceRepository;
import com.example.vinasoy.repository.employees.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private AllowanceRepository allowanceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createPosition(PositionsDTO positionsDTO) {
        String positionId = generatePositionId();
        Position newPosition = modelMapper.map(positionsDTO, Position.class);
        if (positionRepository.existsByNamePosition(positionsDTO.getNamePosition())) {
            throw new AppException(ErrorCode.POSITION_NAME_EXIST);
        }
        else if (positionsDTO.getAllowance() != null) {
            Allowance allowance = allowanceRepository.findById(positionsDTO.getAllowance().getAllowanceId())
                    .orElseThrow(() -> new AppException(ErrorCode.ALLOWANCE_NOT_FOUND));
            newPosition.setAllowance(allowance);
        }
        newPosition.setPositionID(positionId);
        positionRepository.save(newPosition);

    }

    @Override
    public void deletePosition(String positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found with ID: " + positionId));
        positionRepository.delete(position);
    }

    @Override
    public void updatePosition(PositionsDTO positionsDTO) {
        if (positionsDTO == null) {
            throw new IllegalArgumentException("PositionsDTO must not be null");
        }

        Position existingPosition = positionRepository.findById(positionsDTO.getPositionId())
                .orElseThrow(() -> new AppException(ErrorCode.POSITION_NOT_FOUND));

        if (positionsDTO.getNamePosition() != null) {
            existingPosition.setNamePosition(positionsDTO.getNamePosition());
        }

        if (positionsDTO.getAllowance() != null) {
            Allowance allowance = modelMapper.map(positionsDTO.getAllowance(), Allowance.class);
            existingPosition.setAllowance(allowance);
        }
        positionRepository.save(existingPosition);
    }


    @Override
    public List<PositionsDTO> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream()
                .map(position -> modelMapper.map(position, PositionsDTO.class))
                .toList();
    }

    @Override
    public PositionsDTO getPositionById(String positionId) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found with ID: " + positionId));
        return modelMapper.map(position, PositionsDTO.class);
    }

    private String generatePositionId() {
        return positionRepository.findAll()
                .stream()
                .map(Position::getPositionID)
                .max(String::compareTo)
                .map(currentMaxId -> {
                    int currentNumber = Integer.parseInt(currentMaxId.split("-")[1]);
                    return String.format("POS-%04d", currentNumber + 1);
                })
                .orElse("POS-0001");
    }
}
