package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.service.sales.implement.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> findAllOrder() {
        List<OrderDTO> orders = orderService.findAllOrders();
        ApiResponse<List<OrderDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(orders);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable("id") String id) {
        OrderDTO order = orderService.findOrderById(id.toUpperCase());
        ApiResponse<OrderDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(order);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody @Valid OrderDTO orderRequest) {
        OrderDTO orderResponse = orderService.addOrder(orderRequest);
        ApiResponse<OrderDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") String orderId, @RequestBody @Valid OrderDTO orderRequest) {
        OrderDTO orderResponse = orderService.updateOrder(orderId.toUpperCase(), orderRequest);
        ApiResponse<OrderDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") String orderId) {
        orderService.deleteOrder(orderId.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/page")
    public ResponseEntity<?> findAllCustomer(
            @RequestParam(defaultValue = "5", required = false) final Integer pageSize,
            @RequestParam(defaultValue = "0", required = false) final Integer pageNo,
            @RequestParam(defaultValue = "id", required = false) final String... sortBy) {
        PageResponse<?> orderPageResponse = orderService.findAllPaginationWithSortByMultipleColumns(pageSize, pageNo, sortBy);
        ApiResponse<PageResponse<?>> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderPageResponse);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
