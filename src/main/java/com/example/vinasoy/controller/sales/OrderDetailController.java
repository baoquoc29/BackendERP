package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.dto.sales.OrderdetailsDTO;
import com.example.vinasoy.service.sales.implement.OrderDetailService;
import com.example.vinasoy.service.sales.implement.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orderDetail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<?> findAllOrderDetail() {
        List<OrderdetailsDTO> orderDetails = orderDetailService.findAllOrderDetail();
        ApiResponse< List<OrderdetailsDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderDetails);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addOrderDetail(@RequestBody @Valid OrderdetailsDTO orderDetailRequest) {
        OrderdetailsDTO orderDetailResponse = orderDetailService.addOrderDetail(orderDetailRequest);
        ApiResponse<OrderdetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderDetailResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOrderDetailById(@PathVariable("id") String id) {
        OrderdetailsDTO orderdetailsDTO = orderDetailService.findOrderDetailById(id.toUpperCase());
        ApiResponse<OrderdetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderdetailsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(@PathVariable("id") String orderDetailId, @RequestBody @Valid OrderdetailsDTO orderDetailRequest) {
        OrderdetailsDTO orderDetailResponse = orderDetailService.updateOrderDetail(orderDetailId.toUpperCase(), orderDetailRequest);
        ApiResponse<OrderdetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(orderDetailResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") String orderDetailId) {
        orderDetailService.deleteOrderDetail(orderDetailId.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
