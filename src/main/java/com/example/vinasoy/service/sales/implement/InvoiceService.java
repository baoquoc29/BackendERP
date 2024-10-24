package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.sales.Customer;
import com.example.vinasoy.entity.sales.Invoice;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.EmployeeRepository;
import com.example.vinasoy.repository.sales.IInvoiceRepository;
import com.example.vinasoy.service.sales.IInvoiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceService implements IInvoiceService {
    private final IInvoiceRepository invoiceRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public String generateOrderCode() {
        String maxOrderCode = invoiceRepository.findMaxOrderCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "IV-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(3));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "IV-" + newCodeNumber;
        }
    }

    @Override
    public List<InvoiceDTO> findAllInvoice() {
        return invoiceRepository.findAll().stream()
                .map(invoice -> {
                    // Tạo đối tượng InvoiceDTO từ invoice entity
                    InvoiceDTO invoiceDTO = modelMapper.map(invoice, InvoiceDTO.class);

                    // Lấy thông tin Order và set vào InvoiceDTO
                    OrderDTO orderDTO = modelMapper.map(invoice.getOrder(), OrderDTO.class);
                    invoiceDTO.setOrderId(orderDTO.getOrderId());

                    // Lấy thông tin Employee và set vào InvoiceDTO
                    EmployeeDTO employeeDTO = modelMapper.map(invoice.getEmployee(), EmployeeDTO.class);
                    invoiceDTO.setEmployeeId(employeeDTO.getEmployeeId());

                    // Trả về InvoiceDTO
                    return invoiceDTO;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        invoiceDTO.setInvoiceId(this.generateOrderCode());
        Invoice invoice = modelMapper.map(invoiceDTO, Invoice.class);

        Order order = modelMapper.map(orderService.findOrderById(invoiceDTO.getOrderId()), Order.class);
        invoice.setOrder(order);

        Employee employee = employeeRepository.findById(invoiceDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        invoice.setEmployee(employee);

        Invoice newInvoice = invoiceRepository.save(invoice);
        InvoiceDTO newInvoiceDTO = modelMapper.map(newInvoice, InvoiceDTO.class);
        newInvoiceDTO.setOrderId(newInvoice.getOrder().getOrderID());
        newInvoiceDTO.setEmployeeId(newInvoice.getEmployee().getEmployeeID());
        return newInvoiceDTO;
    }

    @Override
    @Transactional
    public InvoiceDTO updateInvoice(String invoiceId, InvoiceDTO invoiceDTO) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Order order = modelMapper.map(orderService.findOrderById(invoiceDTO.getOrderId()), Order.class);
        invoice.setOrder(order);

        Employee employee = employeeRepository.findById(invoiceDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        invoice.setEmployee(employee);

        invoice.setPaymentDate(invoiceDTO.getPaymentDate());
        invoice.setTotalAmount(invoiceDTO.getTotalAmount());
        invoice.setPaymentMethod(invoiceDTO.getPaymentMethod());

        Invoice updateInvoice = invoiceRepository.save(invoice);
        InvoiceDTO updateInvoiceDTO = modelMapper.map(updateInvoice, InvoiceDTO.class);
        updateInvoiceDTO.setOrderId(updateInvoice.getEmployee().getEmployeeID());
        updateInvoiceDTO.setEmployeeId(updateInvoice.getEmployee().getEmployeeID());
        return updateInvoiceDTO;
    }

    @Override
    public void deleteInvoice(String invoiceId) {
        if(!invoiceRepository.existsById(invoiceId))
            throw new AppException(ErrorCode.NOT_EXITS);

        invoiceRepository.deleteById(invoiceId);
    }

    @Override
    public InvoiceDTO findInvoiceById(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        InvoiceDTO invoiceDTO =  modelMapper.map(invoice, InvoiceDTO.class);
        invoiceDTO.setOrderId(invoice.getOrder().getOrderID());
        invoiceDTO.setEmployeeId(invoice.getEmployee().getEmployeeID());
        return invoiceDTO;
    }
}
