package com.example.vinasoy.dto.employee.socialinsuranceDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SocialinsuranceDTO {

    @NotBlank
    @Size(max = 10)
    private String socialInsuranceID;

    private String employeeID; // Đảm bảo kiểu dữ liệu tương ứng với Employee ID trong lớp Socialinsurance

    @Size(max = 100)
    private String insuranceNumber;

    private LocalDate issueDate;

    private LocalDate expirationDate;

    @Size(max = 100)
    private String issuePlace;

    @Size(max = 100)
    private String healthFacility;
}
