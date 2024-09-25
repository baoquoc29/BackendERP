package com.example.vinasoy.dto.sales;

import lombok.Data;

@Data
public class CustomerDTO {
    private String customerId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;

}
