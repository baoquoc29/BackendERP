package com.example.vinasoy.repository;

import com.example.vinasoy.entity.employee.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Account,String> {

}
