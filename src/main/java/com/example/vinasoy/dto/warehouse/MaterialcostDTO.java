package com.example.vinasoy.dto.warehouse;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class MaterialcostDTO {
    private String materialCostId;
    private String employeeId;
    private String materialReceiptNoteId;
    private String costName;
    private Integer quantity;
    private BigDecimal costUnit;
    private BigDecimal vat;
    private BigDecimal totalAmount;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String note;


}
