package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Size(max = 10)
    @Column(name = "PositionID", nullable = false, length = 10)
    private String positionID;

    @Size(max = 255)
    @Column(name = "NamePosition")
    private String namePosition;

    @Column(name = "AllowanceAmount", precision = 10, scale = 2)
    private BigDecimal allowanceAmount;

}