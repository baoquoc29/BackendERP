package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materialwarehouse")
public class Materialwarehouse {
    @Id
    @Size(max = 10)
    @Column(name = "MaterialWarehouseID", nullable = false, length = 10)
    private String materialWarehouseID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaterialID")
    private Material materialID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Size(max = 50)
    @Column(name = "MWHStatus", length = 50)
    private String mWHStatus;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}