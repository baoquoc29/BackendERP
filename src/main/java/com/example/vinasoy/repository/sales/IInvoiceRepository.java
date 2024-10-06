package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, String> {
    @Query(value = "SELECT i.InvoiceID FROM Invoice i ORDER BY i.InvoiceID DESC LIMIT 1", nativeQuery = true)
    String findMaxOrderCode();
}
