package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAllCustomer();
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO findCustomerById(String customerId);
}
