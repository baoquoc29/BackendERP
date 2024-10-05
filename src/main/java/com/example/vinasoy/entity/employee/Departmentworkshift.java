package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departmentworkshift")
public class Departmentworkshift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    private Department departmentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkShiftID")
    private Workshift workShiftID;

}