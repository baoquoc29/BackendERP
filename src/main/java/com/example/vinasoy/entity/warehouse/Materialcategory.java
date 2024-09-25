package com.example.vinasoy.entity.warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "materialcategory")
public class Materialcategory {
    @Id
    @Column(name = "MaterialCategoryID", nullable = false, length = 10)
    private String materialCategoryID;

    @Column(name = "MaterialCategoryName")
    private String materialCategoryName;

    @Column(name = "Note")
    private String note;

}