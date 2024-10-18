package com.example.vinasoy.repository.warehouse;

import com.example.vinasoy.entity.warehouse.Materialwarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialWarehouseRepository extends JpaRepository<Materialwarehouse, String> {
}
