package com.example.vinasoy.repository.warehouse;

import com.example.vinasoy.entity.warehouse.Productwarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWarehouseRepository extends JpaRepository<Productwarehouse, String> {
}
