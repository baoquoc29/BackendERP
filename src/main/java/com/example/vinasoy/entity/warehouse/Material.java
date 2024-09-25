package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "material")
public class Material {
    @Id
    @Column(name = "MaterialID", nullable = false, length = 10)
    private String materialID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaterialCategoryID")
    private Materialcategory materialCategoryID;

    @Column(name = "MaterialName")
    private String materialName;

    @Column(name = "Unit", length = 50)
    private String unit;

    @Column(name = "Note")
    private String note;

}