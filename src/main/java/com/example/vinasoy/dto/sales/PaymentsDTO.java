package com.example.vinasoy.dto.sales;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class PaymentsDTO {
    private String paymentId;
    private String orderId;
    private BigDecimal paymentAmount;
    private LocalDate paymentDate;
    private String paymentMethod;


}
