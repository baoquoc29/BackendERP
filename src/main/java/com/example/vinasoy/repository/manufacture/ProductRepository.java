package com.example.vinasoy.repository.manufacture;

import com.example.vinasoy.entity.manufacture.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
