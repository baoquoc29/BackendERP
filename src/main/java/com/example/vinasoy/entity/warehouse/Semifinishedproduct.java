package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "semifinishedproduct")
public class Semifinishedproduct {
    @Id
    @Size(max = 10)
    @Column(name = "SemiFinishedProductID", nullable = false, length = 10)
    private String semiFinishedProductID;

    @Size(max = 255)
    @Column(name = "SFPName")
    private String sFPName;

    @Size(max = 50)
    @Column(name = "Unit", length = 50)
    private String unit;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}