package com.example.vinasoy.dto.sales;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OrdersDTO {
    private String orderId;
    private String customerId;
    private LocalDate orderDate;
    private String shippingAddress;
    private String notes;
    private String orderStatus;


}
