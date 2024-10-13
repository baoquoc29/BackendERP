package com.example.vinasoy.repository.manufacture;

import com.example.vinasoy.entity.manufacture.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "select * from product where ProductID = :id", nativeQuery = true)
    Product findOneById (@Param("id") String id);
}
