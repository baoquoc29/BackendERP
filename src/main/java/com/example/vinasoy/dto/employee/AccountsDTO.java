package com.example.vinasoy.dto.employee;

import lombok.Data;

@Data
public class AccountsDTO {
    private String accountId;
    private String employeeId;
    private String username;
    private String accountPassword;
    private String accountRole;

}
