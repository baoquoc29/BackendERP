package com.example.vinasoy.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Size(max = 10)
    @Column(name = "AccountID", nullable = false, length = 10)
    private String accountID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Size(max = 255)
    @Column(name = "Username")
    private String username;

    @Size(max = 255)
    @Column(name = "AccountPassword")
    private String accountPassword;

    @Size(max = 50)
    @Column(name = "AccountRole", length = 50)
    private String accountRole;

}