package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materialissuenotedetail")
public class Materialissuenotedetail {
    @EmbeddedId
    private MaterialissuenotedetailId id;

    @MapsId("materialID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialID", nullable = false)
    private Material materialID;

    @MapsId("materialIssueNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialIssueNoteID", nullable = false)
    private Materialissuenote materialIssueNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "MIsNStatus", length = 50)
    private String mIsNStatus;

    @Column(name = "Note")
    private String note;

}