package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productionwarehouse")
public class Productionwarehouse {
    @Id
    @Column(name = "ProductionWarehouseID", nullable = false, length = 10)
    private String productionWarehouseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SemiFinishedProductID")
    private Semifinishedproduct semiFinishedProductID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "ProductionWHStatus", length = 50)
    private String productionWHStatus;

}