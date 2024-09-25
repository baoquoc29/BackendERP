package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "allowance")
public class Allowance {
    @Id
    @Column(name = "AllowanceID", nullable = false, length = 10)
    private String allowanceID;

    @Column(name = "Amount", precision = 10, scale = 2)
    private BigDecimal amount;

}