package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.OrderDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAllCustomers();
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO findCustomerById(String customerId);
}
