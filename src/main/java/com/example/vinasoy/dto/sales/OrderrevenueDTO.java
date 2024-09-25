package com.example.vinasoy.dto.sales;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class OrderrevenueDTO {
    private String orderRevenueId;
    private String employeeId;
    private String orderId;
    private BigDecimal totalAmount;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String note;


}
