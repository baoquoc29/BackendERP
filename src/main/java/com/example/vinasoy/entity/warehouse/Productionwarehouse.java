package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productionwarehouse")
public class Productionwarehouse {
    @Id
    @Size(max = 10)
    @Column(name = "ProductionWarehouseID", nullable = false, length = 10)
    private String productionWarehouseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SemiFinishedProductID")
    private Semifinishedproduct semiFinishedProductID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Size(max = 50)
    @Column(name = "ProductionWHStatus", length = 50)
    private String productionWHStatus;

}