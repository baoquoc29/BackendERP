package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materialissuenotedetail")
public class Materialissuenotedetail {
    @EmbeddedId
    private MaterialissuenotedetailId id;

    @MapsId("materialIssueNoteID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaterialIssueNoteID", nullable = false)
    private Materialissuenote materialIssueNoteID;

    @Column(name = "Quantity")
    private Integer quantity;

    @Size(max = 50)
    @Column(name = "MIsNStatus", length = 50)
    private String mIsNStatus;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}