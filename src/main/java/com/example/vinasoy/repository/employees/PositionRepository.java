package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,String> {
    boolean existsByNamePosition(String namePosition);
}
