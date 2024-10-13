package com.example.vinasoy.entity.warehouse;

import com.example.vinasoy.entity.manufacture.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "productwarehouse")
public class Productwarehouse {
    @Id
    @Size(max = 10)
    @Column(name = "ProductWarehouseID", nullable = false, length = 10)
    private String productWarehouseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private Product productID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "DateOfImport")
    private LocalDate dateOfImport;

    @Size(max = 50)
    @Column(name = "ProductWHStatus", length = 50)
    private String productWHStatus;

}