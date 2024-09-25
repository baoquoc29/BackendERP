package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.sales.ICustomerRepository;
import com.example.vinasoy.service.sales.ICustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public String generateCustomerCode() {
        String maxCustomerCode = customerRepository.findMaxCustomerCode();

        if (maxCustomerCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "CUST-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxCustomerCode.substring(5));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "CUST-" + newCodeNumber;
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomer() {
        return customerRepository.findAll().stream().map(
                        customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsByPhoneOrEmail(customerDTO.getPhoneNumber(), customerDTO.getEmail()))
            throw new AppException(ErrorCode.EXIST);

        customerDTO.setCustomerId(this.generateCustomerCode());
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerId.toUpperCase()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        customer.setFullName(customerDTO.getFullName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String customerId) {
        if(!customerRepository.existsById(customerId.toUpperCase()))
            throw new AppException(ErrorCode.NOT_FOUND_ID);
        customerRepository.deleteById(customerId.toLowerCase());
    }

    @Override
    public CustomerDTO findCustomerById(String customerId) {
        return modelMapper.map(customerRepository.findById(customerId.toUpperCase()), CustomerDTO.class);
    }
}
