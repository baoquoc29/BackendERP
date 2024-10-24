package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT o.OrderID FROM Orders o ORDER BY o.OrderID DESC LIMIT 1", nativeQuery = true)
    String findMaxOrderCode();

}
