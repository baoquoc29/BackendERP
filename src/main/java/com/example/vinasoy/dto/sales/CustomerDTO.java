package com.example.vinasoy.dto.sales;

import com.example.vinasoy.utils.StringUtils;
import com.example.vinasoy.validator.EmailConstraint;
import com.example.vinasoy.validator.PhoneNumberConstraint;
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
    @EmailConstraint(message = "INVALID_EMAIL")
    private String email;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")
    @PhoneNumberConstraint(message = "INVALID_PHONE")
    private String phoneNumber;

    @NotNull(message = "NULL")
    @NotEmpty(message = "EMPTY")
    private String address;

    public String getFullName() {
        return StringUtils.normalizeString(this.fullName);
    }
}
