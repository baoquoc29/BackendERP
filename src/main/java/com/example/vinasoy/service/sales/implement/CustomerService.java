package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.sales.ICustomerRepository;
import com.example.vinasoy.service.sales.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public String generateOrderCode() {
        String maxOrderCode = customerRepository.findMaxCustomerCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "CUST-0015";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(5));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "CUST-" + newCodeNumber;
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream().map(
                        customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsByFullNameAndPhoneNumberAndEmail(
                customerDTO.getFullName(), customerDTO.getPhoneNumber(), customerDTO.getEmail()))
            throw new AppException(ErrorCode.EXITS);

        customerDTO.setCustomerId(this.generateOrderCode());
        // convert DTO to entity
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        Customer newCustomer =  customerRepository.save(customer);

        // convert entity to DTO
        return modelMapper.map(newCustomer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(String customerId, CustomerDTO customerDTO) {
        if(!customerRepository.existsById(customerId))
            throw new AppException(ErrorCode.NOT_FOUND_ID);

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        customer.setFullName(customerDTO.getFullName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());

        Customer updateCustomer = customerRepository.save(customer);

        return modelMapper.map(updateCustomer, CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(String customerId) {
        if(!customerRepository.existsById(customerId)) {
            throw new AppException(ErrorCode.NOT_FOUND_ID);
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO findCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new AppException(ErrorCode.EXITS));
        return modelMapper.map(customer, CustomerDTO.class);
    }
}
