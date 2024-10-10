package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.dto.sales.OrderdetailsDTO;
import com.example.vinasoy.entity.sales.Orderdetail;

import java.util.List;

public interface IOrderDetailServce {
    List<OrderdetailsDTO> findAllOrderDetail();
    OrderdetailsDTO addOrderDetail(OrderdetailsDTO orderdetailsDTO);
    OrderdetailsDTO updateOrderDetail(String id, OrderdetailsDTO orderDetailDTO);
    void deleteOrderDetail(String orderDetailId);
    OrderdetailsDTO findOrderDetailById(String orderDetailId);
}
