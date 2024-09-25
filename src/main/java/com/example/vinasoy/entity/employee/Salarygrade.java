package com.example.vinasoy.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salarygrade")
public class Salarygrade {
    @Id
    @Column(name = "GradeID", nullable = false, length = 10)
    private String gradeID;

    @Column(name = "NameGrade")
    private String nameGrade;

    @Column(name = "Note", length = 500)
    private String note;

}