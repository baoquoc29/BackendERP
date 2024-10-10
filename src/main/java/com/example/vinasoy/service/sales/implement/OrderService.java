package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employee.EmployeeRepository;
import com.example.vinasoy.repository.sales.ICustomerRepository;
import com.example.vinasoy.repository.sales.IOrderRepository;
import com.example.vinasoy.service.sales.IOrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;
    private final ICustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public String generateOrderCode() {
        String maxOrderCode = orderRepository.findMaxOrderCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "ORD-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(4));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "ORD-" + newCodeNumber;
        }
    }

    @Override
    public List<OrderDTO> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> {
                    OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

                    CustomerDTO customerDTO = modelMapper.map(order.getCustomer(), CustomerDTO.class);
                    orderDTO.setCustomerId(customerDTO.getCustomerId());

                    EmployeeDTO employeeDTO = modelMapper.map(order.getEmployee(), EmployeeDTO.class);
                    orderDTO.setEmployeeId(employeeDTO.getEmployeeId());

                    return orderDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(this.generateOrderCode());
        Order order = modelMapper.map(orderDTO, Order.class);

        Customer customer = modelMapper.map(customerService.findCustomerById(orderDTO.getCustomerId()), Customer.class);
        order.setCustomer(customer);

        Employee employee = employeeRepository.findById(orderDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        order.setEmployee(employee);

        Order newOrder = orderRepository.save(order);
        OrderDTO newOrderDTO = modelMapper.map(newOrder, OrderDTO.class);
        newOrderDTO.setCustomerId(newOrder.getCustomer().getCustomerID());
        newOrderDTO.setEmployeeId(newOrder.getEmployee().getEmployeeID());
        return newOrderDTO;
    }

    @Override
    public OrderDTO updateOrder(String id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Customer customer = modelMapper.map(customerService.findCustomerById(orderDTO.getCustomerId()), Customer.class);
        order.setCustomer(customer);

        Employee employee = employeeRepository.findById(orderDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        order.setEmployee(employee);

        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setNotes(orderDTO.getNotes());
        order.setShippingAddress(orderDTO.getShippingAddress());

        Order updateOrder = orderRepository.save(order);
        OrderDTO newOrderDTO = modelMapper.map(updateOrder, OrderDTO.class);
        newOrderDTO.setCustomerId(updateOrder.getCustomer().getCustomerID());
        newOrderDTO.setEmployeeId(updateOrder.getEmployee().getEmployeeID());
        return newOrderDTO;
    }

    @Override
    public void deleteOrder(String orderId) {
        if(!orderRepository.existsById(orderId))
            throw new AppException(ErrorCode.NOT_EXITS);

        orderRepository.deleteById(orderId);
    }

    @Override
    public OrderDTO findOrderById(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        OrderDTO orderDTO =  modelMapper.map(order, OrderDTO.class);
        orderDTO.setCustomerId(order.getCustomer().getCustomerID());
        orderDTO.setEmployeeId(order.getEmployee().getEmployeeID());
        return orderDTO;
    }
}
