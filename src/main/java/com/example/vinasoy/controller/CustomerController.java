package com.example.vinasoy.controller;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.service.sales.implement.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> findAllCustomer() {
        List<CustomerDTO> customers = customerService.findAllCustomers();
        ApiResponse<List<CustomerDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(customers);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") String id) {
        CustomerDTO carTypeResponse = customerService.findCustomerById(id.toUpperCase());
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(carTypeResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerDTO customerRequest) {
        CustomerDTO carTypeResponse = customerService.addCustomer(customerRequest);
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(carTypeResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") String id,
                                            @RequestBody @Valid CustomerDTO customerRequest) {
        CustomerDTO carTypeResponse = customerService.updateCustomer(id.toUpperCase(), customerRequest);
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(carTypeResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}
