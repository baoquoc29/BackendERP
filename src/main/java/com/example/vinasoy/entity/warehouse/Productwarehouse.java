package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "productwarehouse")
public class Productwarehouse {
    @Id
    @Column(name = "ProductWarehouseID", nullable = false, length = 10)
    private String productWarehouseID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "DateOfImport")
    private LocalDate dateOfImport;

    @Column(name = "ProductWHStatus", length = 50)
    private String productWHStatus;

}