package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @MapsId("materialReceiptNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialReceiptNoteID", nullable = false)
    private Materialreceiptnote materialReceiptNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "UnitPrice", precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}