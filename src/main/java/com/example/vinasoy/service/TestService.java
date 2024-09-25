package com.example.vinasoy.service;

import com.example.vinasoy.entity.employee.Account;
import com.example.vinasoy.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestService implements TestServiceImpl{

    @Autowired
    TestRepository testRepository;
    @Override
    public List<Account> listAccounts() {
        return testRepository.findAll();
    }
}
