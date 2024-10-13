package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionsRepository extends JpaRepository<Position, String> {
    List<Position> findByPositionIDContainingIgnoreCaseOrNamePositionContainingIgnoreCase(String positionID, String namePosition);

}
