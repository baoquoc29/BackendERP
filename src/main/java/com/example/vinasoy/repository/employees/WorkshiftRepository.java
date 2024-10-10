package com.example.vinasoy.repository.employees;

import com.example.vinasoy.entity.employee.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshiftRepository  extends JpaRepository<Workshift,String> {
}
