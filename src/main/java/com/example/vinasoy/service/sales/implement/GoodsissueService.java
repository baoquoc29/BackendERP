package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.controller.sales.PageResponse;
import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.dto.sales.GoodsissueDTO;
import com.example.vinasoy.dto.sales.GoodsreceiptDTO;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.dto.sales.InvoicedetailsDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.example.vinasoy.entity.sales.Goodsissue;
import com.example.vinasoy.entity.sales.Goodsreceipt;
import com.example.vinasoy.entity.sales.Invoice;
import com.example.vinasoy.entity.sales.Order;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.EmployeeRepository;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.repository.sales.IGoodsissueRepository;
import com.example.vinasoy.service.sales.IGoodsissueService;
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
public class GoodsissueService implements IGoodsissueService {
    private final ModelMapper modelMapper;
    private final IGoodsissueRepository goodsissueRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;
    private final InvoiceService invoiceService;

    public String generateOrderCode() {
        String maxOrderCode = goodsissueRepository.findMaxCustomerCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "GI-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(3));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "GI-" + newCodeNumber;
        }
    }

    @Override
    public List<GoodsissueDTO> findAllGoodsissue() {
        return goodsissueRepository.findAll().stream()
                .map(goodsissue -> {

                    GoodsissueDTO goodsissueDTO = modelMapper.map(goodsissue, GoodsissueDTO.class);

                    InvoiceDTO invoiceDTO = modelMapper.map(goodsissue.getInvoice(), InvoiceDTO.class);
                    goodsissueDTO.setInvoiceId(invoiceDTO.getInvoiceId());

                    ProductDTO productDTO = modelMapper.map(goodsissue.getProduct(), ProductDTO.class);
                    goodsissueDTO.setProductId(productDTO.getProductId());

                    EmployeeDTO employeeDTO = modelMapper.map(goodsissue.getEmployee(), EmployeeDTO.class);
                    goodsissueDTO.setEmployeeId(employeeDTO.getEmployeeId());


                    return goodsissueDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public GoodsissueDTO addGoodsissue(GoodsissueDTO goodsissueDTO) {
        goodsissueDTO.setGoodsIssueId(this.generateOrderCode());
        Goodsissue goodsissue = modelMapper.map(goodsissueDTO, Goodsissue.class);

        Invoice invoice = modelMapper.map(invoiceService.findInvoiceById(goodsissueDTO.getInvoiceId()), Invoice.class);
        goodsissue.setInvoice(invoice);

        Employee employee = employeeRepository.findById(goodsissueDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsissue.setEmployee(employee);

        Product product = productRepository.findById(goodsissueDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsissue.setProduct(product);

        Goodsissue newGoodsIssuse = goodsissueRepository.save(goodsissue);
        GoodsissueDTO newGoodsIssuseDTO = modelMapper.map(newGoodsIssuse, GoodsissueDTO.class);
        newGoodsIssuseDTO.setInvoiceId(newGoodsIssuse.getInvoice().getInvoiceId());
        newGoodsIssuseDTO.setEmployeeId(newGoodsIssuse.getEmployee().getEmployeeID());
        newGoodsIssuseDTO.setProductId(newGoodsIssuse.getProduct().getProductId());
        return newGoodsIssuseDTO;
    }

    @Override
    public GoodsissueDTO updateGoodsissue(String goodsissueId, GoodsissueDTO goodsissueDTO) {
        Goodsissue goodsissue = goodsissueRepository.findById(goodsissueId).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Invoice invoice = modelMapper.map(invoiceService.findInvoiceById(goodsissueDTO.getInvoiceId()), Invoice.class);
        goodsissue.setInvoice(invoice);

        Employee employee = employeeRepository.findById(goodsissueDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsissue.setEmployee(employee);

        Product product = productRepository.findById(goodsissueDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsissue.setProduct(product);

        goodsissue.setNote(goodsissueDTO.getNote());
        goodsissue.setExportPrice(goodsissueDTO.getExportPrice());
        goodsissue.setQuantityExported(goodsissueDTO.getQuantityExported());
        goodsissue.setExportDate(goodsissueDTO.getExportDate());


        Goodsissue updateGoodsissue = goodsissueRepository.save(goodsissue);
        GoodsissueDTO updateGoodIssueDTO = modelMapper.map(updateGoodsissue, GoodsissueDTO.class);
        updateGoodIssueDTO.setInvoiceId(updateGoodsissue.getInvoice().getInvoiceId());
        updateGoodIssueDTO.setEmployeeId(updateGoodsissue.getEmployee().getEmployeeID());
        updateGoodIssueDTO.setProductId(updateGoodsissue.getProduct().getProductId());
        return updateGoodIssueDTO;
    }

    @Override
    public void deleteGoodsissue(String goodsissueId) {
        if(!goodsissueRepository.existsById(goodsissueId))
            throw new AppException(ErrorCode.NOT_EXITS);

        goodsissueRepository.deleteById(goodsissueId);
    }

    @Override
    public GoodsissueDTO findGoodsissueById(String goodsissueId) {
        Goodsissue goodsissue = goodsissueRepository.findById(goodsissueId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        GoodsissueDTO goodsissueDTO =  modelMapper.map(goodsissue, GoodsissueDTO.class);
        goodsissueDTO.setInvoiceId(goodsissue.getInvoice().getInvoiceId());
        goodsissueDTO.setEmployeeId(goodsissue.getEmployee().getEmployeeID());
        goodsissueDTO.setProductId(goodsissue.getProduct().getProductId());
        return goodsissueDTO;
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

        Page<Goodsissue> goodsissues = goodsissueRepository.findAll(pageable);

        List<GoodsissueDTO> goodsissueDTOS = goodsissues.stream()
                .map(goodsissue -> {

                    GoodsissueDTO goodsissueDTO = modelMapper.map(goodsissue, GoodsissueDTO.class);

                    InvoiceDTO invoiceDTO = modelMapper.map(goodsissue.getInvoice(), InvoiceDTO.class);
                    goodsissueDTO.setInvoiceId(invoiceDTO.getInvoiceId());

                    ProductDTO productDTO = modelMapper.map(goodsissue.getProduct(), ProductDTO.class);
                    goodsissueDTO.setProductId(productDTO.getProductId());

                    EmployeeDTO employeeDTO = modelMapper.map(goodsissue.getEmployee(), EmployeeDTO.class);
                    goodsissueDTO.setEmployeeId(employeeDTO.getEmployeeId());


                    return goodsissueDTO;
                }).collect(Collectors.toList());

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPage(goodsissues.getTotalPages())
                .totalElements(goodsissues.getTotalElements())
                .items(goodsissueDTOS)
                .build();
    }
}
