package com.example.vinasoy.dto.sales;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String customerId;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")
    private String fullName;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")

    private String email;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")

    private String phoneNumber;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")
    private String address;

}
