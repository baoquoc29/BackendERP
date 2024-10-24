package com.example.vinasoy.repository.sales;

import com.example.vinasoy.entity.sales.Invoicedetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceDetailRepository extends JpaRepository<Invoicedetails, String> {
    @Query(value = "SELECT id.InvoiceDetailID FROM InvoiceDetails id ORDER BY id.InvoiceDetailID DESC LIMIT 1", nativeQuery = true)
    String findMaxOrderCode();
}
