package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "materialreceiptnotedetail")
public class Materialreceiptnotedetail {
    @EmbeddedId
    private MaterialreceiptnotedetailId id;

    @MapsId("materialID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialID", nullable = false)
    private Material materialID;

    @MapsId("materialReceiptNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialReceiptNoteID", nullable = false)
    private Materialreceiptnote materialReceiptNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "Note")
    private String note;

}