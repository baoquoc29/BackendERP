package com.example.vinasoy.controller;

import com.example.vinasoy.entity.employee.Account;
import com.example.vinasoy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TestController{
    @Autowired
    TestService testService;
    @GetMapping("/test")
    public List<Account> test(){
        return testService.listAccounts();
    }
}
