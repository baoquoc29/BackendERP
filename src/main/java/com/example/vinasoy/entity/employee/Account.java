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
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "AccountID", nullable = false, length = 10)
    private String accountID;

    @Column(name = "UserName")
    private String username;

    @Column(name = "AccountPassword")
    private String accountPassword;

    @Column(name = "AccountRole", length = 50)
    private String accountRole;

}