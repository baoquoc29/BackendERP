package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRespository extends JpaRepository<Orderdetail, String> {
    @Query(value = "SELECT od.OrderDetailID FROM orderDetails od ORDER BY od.OrderDetailID DESC LIMIT 1", nativeQuery = true)
    String findMaxOrderCode();
}
