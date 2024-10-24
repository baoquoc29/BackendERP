package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.controller.sales.PageResponse;
import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.dto.sales.OrderdetailsDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.entity.sales.Orderdetail;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.repository.sales.IOrderDetailRespository;
import com.example.vinasoy.service.sales.IOrderDetailServce;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailService implements IOrderDetailServce {
    private final ModelMapper modelMapper;
    private final IOrderDetailRespository orderDetailRespository;
    private final OrderService orderService;
    private final ProductRepository productRepository;


    public String generateOrderCode() {
        String maxOrderCode = orderDetailRespository.findMaxOrderCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "OD-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(3));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "OD-" + newCodeNumber;
        }
    }

    @Override
    public List<OrderdetailsDTO> findAllOrderDetail() {
        return orderDetailRespository.findAll().stream()
                .map(orderDetail -> {
                    OrderdetailsDTO orderdetailsDTO = modelMapper.map(orderDetail, OrderdetailsDTO.class);

                    OrderDTO orderDTO = modelMapper.map(orderDetail.getOrder(), OrderDTO.class);
                    orderdetailsDTO.setOrderId(orderDTO.getOrderId());

                    ProductDTO productDTO  = modelMapper.map(orderDetail.getProduct(), ProductDTO.class);
                    orderdetailsDTO.setProductId(productDTO.getProductId());

                    return orderdetailsDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public OrderdetailsDTO addOrderDetail(OrderdetailsDTO orderdetailsDTO) {
        orderdetailsDTO.setOrderDetailId(this.generateOrderCode());
        Orderdetail orderdetail = modelMapper.map(orderdetailsDTO, Orderdetail.class);

        Order order = modelMapper.map(orderService.findOrderById(orderdetailsDTO.getOrderId()), Order.class);
        orderdetail.setOrder(order);

        Product product = productRepository.findById(orderdetailsDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        orderdetail.setProduct(product);

        Orderdetail newOrderDetail = orderDetailRespository.save(orderdetail);
        OrderdetailsDTO newOrderDetailDTO = modelMapper.map(newOrderDetail, OrderdetailsDTO.class);
        newOrderDetailDTO.setOrderId(newOrderDetail.getOrder().getOrderID());
        newOrderDetailDTO.setProductId(newOrderDetail.getProduct().getProductId());
        return newOrderDetailDTO;
    }

    @Override
    public OrderdetailsDTO updateOrderDetail(String id, OrderdetailsDTO orderDetailDTO) {
        Orderdetail orderdetail = orderDetailRespository.findById(id).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Order order = modelMapper.map(orderService.findOrderById(orderDetailDTO.getOrderId()), Order.class);
        orderdetail.setOrder(order);

        Product product = productRepository.findById(orderDetailDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        orderdetail.setProduct(product);

        orderdetail.setQuantity(orderDetailDTO.getQuantity());
        orderdetail.setUnitPrice(orderDetailDTO.getUnitPrice());
        orderdetail.setTotalPrice(orderDetailDTO.getTotalPrice());

        Orderdetail updateOrderDetail = orderDetailRespository.save(orderdetail);
        OrderdetailsDTO newOrderDetailDTO = modelMapper.map(updateOrderDetail, OrderdetailsDTO.class);
        newOrderDetailDTO.setOrderId(updateOrderDetail.getOrder().getOrderID());
        newOrderDetailDTO.setProductId(updateOrderDetail.getProduct().getProductId());
        return newOrderDetailDTO;
    }

    @Override
    public void deleteOrderDetail(String orderDetailId) {
        if(!orderDetailRespository.existsById(orderDetailId))
            throw new AppException(ErrorCode.NOT_EXITS);

        orderDetailRespository.deleteById(orderDetailId);
    }

    @Override
    public OrderdetailsDTO findOrderDetailById(String orderDetailId) {
        Orderdetail orderdetail = orderDetailRespository.findById(orderDetailId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        OrderdetailsDTO orderdetailsDTO =  modelMapper.map(orderdetail, OrderdetailsDTO.class);
        orderdetailsDTO.setOrderId(orderdetail.getOrder().getOrderID());
        orderdetailsDTO.setProductId(orderdetail.getProduct().getProductId());
        return orderdetailsDTO;
    }

    public PageResponse<?> findAllPaginationWithSortByMultipleColumns(final Integer pageSize, final Integer pageNo, final String... sorts) {
        List<Sort.Order> orders = new ArrayList<>();

        for (String sortBy: sorts) {
            //firstName:asc|desc
            Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?)");
            Matcher matcher = pattern.matcher(sortBy);
            if (matcher.find()) {
                if (matcher.group(3).equalsIgnoreCase("asc")) {
                    orders.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
                } else {
                    orders.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
                }
            }
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(orders));

        Page<Orderdetail> orderDetails = orderDetailRespository.findAll(pageable);

        List<OrderdetailsDTO> orderDetailsDTOs = orderDetails.stream()
                .map(orderDetail -> {
                    OrderdetailsDTO orderdetailsDTO = modelMapper.map(orderDetail, OrderdetailsDTO.class);

                    OrderDTO orderDTO = modelMapper.map(orderDetail.getOrder(), OrderDTO.class);
                    orderdetailsDTO.setOrderId(orderDTO.getOrderId());

                    ProductDTO productDTO  = modelMapper.map(orderDetail.getProduct(), ProductDTO.class);
                    orderdetailsDTO.setProductId(productDTO.getProductId());

                    return orderdetailsDTO;
                }).collect(Collectors.toList());

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(orderDetails.getTotalPages())
                .totalElements(orderDetails.getTotalElements())
                .items(orderDetailsDTOs)
                .build();
    }
}