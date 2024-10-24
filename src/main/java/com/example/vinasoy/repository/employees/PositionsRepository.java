package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionsRepository extends JpaRepository<Position, String> {
    List<Position> findByPositionIDContainingIgnoreCaseOrNamePositionContainingIgnoreCase(String positionID, String namePosition);
    @Query("SELECT pt.namePosition from Position pt")
    List<String> findAllnamePosition();
}
