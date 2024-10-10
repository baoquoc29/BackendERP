package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.dto.sales.InvoicedetailsDTO;
import com.example.vinasoy.dto.sales.OrderDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.example.vinasoy.entity.sales.Invoice;
import com.example.vinasoy.entity.sales.Invoicedetails;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.repository.sales.IInvoiceDetailRepository;
import com.example.vinasoy.service.sales.IInvoiceDetailService;
import com.example.vinasoy.service.sales.IInvoiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceDetailService implements IInvoiceDetailService {
    private final ModelMapper modelMapper;
    private final IInvoiceDetailRepository invoiceDetailRepository;
    private final IInvoiceService invoiceService;
    private final ProductRepository productRepository;


    public String generateOrderCode() {
        String maxOrderCode = invoiceDetailRepository.findMaxOrderCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "IVD-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(4));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "IVD-" + newCodeNumber;
        }
    }

    @Override
    public List<InvoicedetailsDTO> findAllInvoiceDetail() {
        return invoiceDetailRepository.findAll().stream()
                .map(invoicedetail -> {

                    InvoicedetailsDTO invoicedetailDTO = modelMapper.map(invoicedetail, InvoicedetailsDTO.class);

                    InvoiceDTO invoiceDTO = modelMapper.map(invoicedetail.getInvoice(), InvoiceDTO.class);
                    invoicedetailDTO.setInvoiceId(invoiceDTO.getInvoiceId());

                    ProductDTO productDTO = modelMapper.map(invoicedetail.getProduct(), ProductDTO.class);
                    invoicedetailDTO.setProductId(productDTO.getProductId());


                    return invoicedetailDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public InvoicedetailsDTO addInvoiceDetail(InvoicedetailsDTO invoicedetailsDTO) {
        invoicedetailsDTO.setInvoiceDetailId(this.generateOrderCode());
        Invoicedetails invoicedetails = modelMapper.map(invoicedetailsDTO, Invoicedetails.class);

        Invoice invoice = modelMapper.map(invoiceService.findInvoiceById(invoicedetailsDTO.getInvoiceId()), Invoice.class);
        invoicedetails.setInvoice(invoice);

        Product product = productRepository.findById(invoicedetailsDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        invoicedetails.setProduct(product);

        Invoicedetails newInvoiceDetail = invoiceDetailRepository.save(invoicedetails);
        InvoicedetailsDTO newInvoiceDetailDTO = modelMapper.map(newInvoiceDetail, InvoicedetailsDTO.class);
        newInvoiceDetailDTO.setInvoiceId(newInvoiceDetail.getInvoice().getInvoiceId());
        newInvoiceDetailDTO.setProductId(newInvoiceDetail.getProduct().getProductId());
        return newInvoiceDetailDTO;
    }

    @Override
    public InvoicedetailsDTO updateInvoiceDetail(String invoiceDetailId, InvoicedetailsDTO invoicedetailsDTO) {
        Invoicedetails invoicedetails = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Invoice invoice = modelMapper.map(invoiceService.findInvoiceById(invoicedetailsDTO.getInvoiceId()), Invoice.class);
        invoicedetails.setInvoice(invoice);

        Product product = productRepository.findById(invoicedetailsDTO.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        invoicedetails.setProduct(product);

        invoicedetails.setProductPrice(invoicedetailsDTO.getProductPrice());
        invoicedetails.setQuantity(invoicedetailsDTO.getQuantity());
        invoicedetails.setTotalInvoice(invoicedetailsDTO.getTotalInvoice());
        invoicedetails.setInvoiceStatus(invoicedetailsDTO.getInvoiceStatus());

        Invoicedetails updateInvoiceDetail = invoiceDetailRepository.save(invoicedetails);
        InvoicedetailsDTO updateInvoiceDetailsDTO = modelMapper.map(updateInvoiceDetail, InvoicedetailsDTO.class);
        updateInvoiceDetailsDTO.setInvoiceId(updateInvoiceDetail.getInvoice().getInvoiceId());
        updateInvoiceDetailsDTO.setProductId(updateInvoiceDetail.getProduct().getProductId());
        return updateInvoiceDetailsDTO;
    }

    @Override
    public void deleteInvoiceDetail(String invoiceDetailId) {
        if(!invoiceDetailRepository.existsById(invoiceDetailId))
            throw new AppException(ErrorCode.NOT_EXITS);

        invoiceDetailRepository.deleteById(invoiceDetailId);
    }

    @Override
    public InvoicedetailsDTO findInvoiceDetailById(String invoiceDetailId) {
        Invoicedetails invoicedetails = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        InvoicedetailsDTO invoiceDetailsDTO =  modelMapper.map(invoicedetails, InvoicedetailsDTO.class);
        invoiceDetailsDTO.setInvoiceId(invoicedetails.getInvoice().getInvoiceId());
        invoiceDetailsDTO.setProductId(invoicedetails.getProduct().getProductId());
        return invoiceDetailsDTO;
    }
}
