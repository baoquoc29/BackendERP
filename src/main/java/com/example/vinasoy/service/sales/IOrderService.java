package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> findAllOrders();
    OrderDTO addOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(String id, OrderDTO orderDTO);
    void deleteOrder(String orderId);
    OrderDTO findOrderById(String orderId);
}
