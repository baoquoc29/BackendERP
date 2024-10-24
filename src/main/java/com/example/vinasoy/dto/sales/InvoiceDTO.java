package com.example.vinasoy.dto.sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private String invoiceId;
    private String orderId;
    private String employeeId;
    private BigDecimal totalAmount;
    private LocalDate paymentDate;
    private String paymentMethod;
}
