package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "material")
public class Material {
    @Id
    @Size(max = 10)
    @Column(name = "MaterialID", nullable = false, length = 10)
    private String materialID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaterialCategoryID")
    private Materialcategory materialCategoryID;

    @Size(max = 255)
    @Column(name = "MaterialName")
    private String materialName;

    @Size(max = 50)
    @Column(name = "Unit", length = 50)
    private String unit;

    @Size(max = 255)
    @Column(name = "Note")
    private String note;

}