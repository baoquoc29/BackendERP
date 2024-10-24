package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Goodsreceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoodsreceiptRepository extends JpaRepository<Goodsreceipt, String> {
    @Query(value = "SELECT c.GoodsReceiptID FROM GoodsReceipt c ORDER BY c.GoodsReceiptID DESC LIMIT 1", nativeQuery = true)
    String findMaxCustomerCode();
}
