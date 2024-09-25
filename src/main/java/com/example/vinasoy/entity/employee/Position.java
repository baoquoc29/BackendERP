package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Column(name = "PositionID", nullable = false, length = 10)
    private String positionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AllowanceID")
    private Allowance allowance;

    @Column(name = "NamePosition")
    private String namePosition;

}