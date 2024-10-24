package com.example.vinasoy.repository.income;

import com.example.vinasoy.dto.income.RevenueDTO;
import com.example.vinasoy.entity.income.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RevenueRepository extends JpaRepository<Revenue, String> {
    @Query("SELECT new com.example.vinasoy.dto.income.RevenueDTO(rv.revenueID, emp.employeeName, iv.paymentMethod, rv.revenueName, rv.vat, rv.grossRevenue, rv.actualRevenue,rv.createDate, rv.note) " +
            "FROM Revenue rv " +
            "JOIN rv.employeeID emp " +
            "JOIN rv.invoiceID iv " +
            "WHERE (:month IS NULL OR MONTH(rv.createDate) = :month) " +
            "AND (:year IS NULL OR YEAR(rv.createDate) = :year)")
    List<RevenueDTO> getRevenue(@Param("month") Integer month, @Param("year") Integer year);


}
