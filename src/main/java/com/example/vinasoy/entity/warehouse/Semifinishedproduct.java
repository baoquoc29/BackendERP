package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "semifinishedproduct")
public class Semifinishedproduct {
    @Id
    @Column(name = "SemiFinishedProductID", nullable = false, length = 10)
    private String semiFinishedProductID;

    @Column(name = "SFPName")
    private String sFPName;

    @Column(name = "Unit", length = 50)
    private String unit;

    @Column(name = "Note")
    private String note;

}