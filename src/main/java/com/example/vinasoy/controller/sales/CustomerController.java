package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.service.sales.implement.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/search")
    public ResponseEntity<?> searchCustomers(
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String address,
            @RequestParam(defaultValue = "customerId,asc", required = false) String... sort) {

        PageResponse<?> result = customerService.searchCustomers(
                pageSize, pageNo, customerId, fullName, email, phoneNumber, address, sort);
        ApiResponse<PageResponse<?>> apiResponse = new ApiResponse<>();
        apiResponse.setData(result);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/page")
    public ResponseEntity<?> findAllCustomer(
            @RequestParam(defaultValue = "5", required = false) final Integer pageSize,
            @RequestParam(defaultValue = "0", required = false) final Integer pageNo,
            @RequestParam(defaultValue = "id", required = false) final String... sortBy) {
        PageResponse<?> customerPageResponse = customerService.findAllPaginationWithSortByMultipleColumns(pageSize, pageNo, sortBy);
        ApiResponse<PageResponse<?>> apiResponse = new ApiResponse<>();
        apiResponse.setData(customerPageResponse);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

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
        CustomerDTO customerDTO = customerService.addCustomer(customerRequest);
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") String id,
                                            @RequestBody @Valid CustomerDTO customerRequest) {
        CustomerDTO customerDTO = customerService.updateCustomer(id.toUpperCase(), customerRequest);
        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(customerDTO);
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
