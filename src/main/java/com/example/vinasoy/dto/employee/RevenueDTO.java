package com.example.vinasoy.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class RevenueDTO {
    private String revenueId;
    private String employeeId;
    private String invoiceId;
    private String revenueName;
    private Integer vat;
    private BigDecimal grossRevenue;
    private BigDecimal actualRevenue;
    private LocalDate createDate;
    private LocalDate updateDate;
    private String note;

}
