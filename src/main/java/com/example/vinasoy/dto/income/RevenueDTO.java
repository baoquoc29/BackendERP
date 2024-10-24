package com.example.vinasoy.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueDTO {
    private String revenueId;
    private String employeeName;
    private String paymentMethod;
    private String revenueName;
    private Integer vat;
    private BigDecimal grossRevenue;
    private BigDecimal actualRevenue;
    private LocalDate createDate;
    private String note;

}
