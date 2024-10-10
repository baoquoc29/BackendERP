package com.example.vinasoy.service.sales.implement;

import com.example.vinasoy.dto.employee.EmployeeDTO;
import com.example.vinasoy.dto.manufacture.ProductDTO;
import com.example.vinasoy.dto.sales.GoodsissueDTO;
import com.example.vinasoy.dto.sales.GoodsreceiptDTO;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.entity.employee.Employee;
import com.example.vinasoy.entity.manufacture.Product;
import com.example.vinasoy.entity.sales.Goodsissue;
import com.example.vinasoy.entity.sales.Goodsreceipt;
import com.example.vinasoy.entity.sales.Invoice;
import com.example.vinasoy.exception.AppException;
import com.example.vinasoy.exception.ErrorCode;
import com.example.vinasoy.repository.employees.EmployeeRepository;
import com.example.vinasoy.repository.manufacture.ProductRepository;
import com.example.vinasoy.repository.sales.IGoodsissueRepository;
import com.example.vinasoy.repository.sales.IGoodsreceiptRepository;
import com.example.vinasoy.service.sales.IGoodsreceiptService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsreceiptService implements IGoodsreceiptService {
    private final ModelMapper modelMapper;
    private final IGoodsreceiptRepository goodsreceiptRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;


    public String generateOrderCode() {
        String maxOrderCode = goodsreceiptRepository.findMaxCustomerCode();

        if (maxOrderCode == null) {
            // Nếu không có mã nào trong DB, bắt đầu từ "CUST-0001"
            return "GR-0001";
        } else {
            // Lấy phần số từ mã hiện tại và tăng lên 1
            int maxCodeNumber = Integer.parseInt(maxOrderCode.substring(3));
            String newCodeNumber = String.format("%04d", maxCodeNumber + 1);
            return "GR-" + newCodeNumber;
        }
    }

    @Override
    public List<GoodsreceiptDTO> findAllGoodsreceipt() {
        return goodsreceiptRepository.findAll().stream()
                .map(goodsreceipt -> {

                    GoodsreceiptDTO goodsreceiptDTO = modelMapper.map(goodsreceipt, GoodsreceiptDTO.class);

                    ProductDTO productDTO = modelMapper.map(goodsreceipt.getProduct(), ProductDTO.class);
                    goodsreceiptDTO.setProductId(productDTO.getProductId());

                    EmployeeDTO employeeDTO = modelMapper.map(goodsreceipt.getEmployee(), EmployeeDTO.class);
                    goodsreceiptDTO.setEmployeeId(employeeDTO.getEmployeeId());


                    return goodsreceiptDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public GoodsreceiptDTO addGoodsreceipt(GoodsreceiptDTO goodsreceiptDTO) {
        goodsreceiptDTO.setGoodsReceiptId(this.generateOrderCode());
        Goodsreceipt goodsreceipt = modelMapper.map(goodsreceiptDTO, Goodsreceipt.class);

        Employee employee = employeeRepository.findById(goodsreceiptDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsreceipt.setEmployee(employee);

        Product product = productRepository.findById(goodsreceiptDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsreceipt.setProduct(product);

        Goodsreceipt newGoodReceipt = goodsreceiptRepository.save(goodsreceipt);

        GoodsreceiptDTO newGoodReceiptDTO = modelMapper.map(newGoodReceipt, GoodsreceiptDTO.class);
        newGoodReceiptDTO.setEmployeeId(newGoodReceipt.getEmployee().getEmployeeID());
        newGoodReceiptDTO.setProductId(newGoodReceipt.getProduct().getProductId());
        return newGoodReceiptDTO;
    }

    @Override
    public GoodsreceiptDTO updateGoodsreceipt(String goodsissueId, GoodsreceiptDTO goodsreceiptDTO) {
        Goodsreceipt goodsreceipt = goodsreceiptRepository.findById(goodsissueId).orElseThrow(() -> new AppException(ErrorCode.EXITS));

        Employee employee = employeeRepository.findById(goodsreceiptDTO.getEmployeeId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsreceipt.setEmployee(employee);

        Product product = productRepository.findById(goodsreceiptDTO.getProductId()).orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND_ID));
        goodsreceipt.setProduct(product);

        goodsreceipt.setNote(goodsreceiptDTO.getNote());
        goodsreceipt.setImportDate(goodsreceiptDTO.getImportDate());
        goodsreceipt.setImportPrice(goodsreceiptDTO.getImportPrice());
        goodsreceipt.setQuantityImported(goodsreceiptDTO.getQuantityImported());

        Goodsreceipt updateGoodsissue = goodsreceiptRepository.save(goodsreceipt);
        GoodsreceiptDTO updateGoodIssueDTO = modelMapper.map(updateGoodsissue, GoodsreceiptDTO.class);
        updateGoodIssueDTO.setEmployeeId(updateGoodsissue.getEmployee().getEmployeeID());
        updateGoodIssueDTO.setProductId(updateGoodsissue.getProduct().getProductId());
        return updateGoodIssueDTO;
    }

    @Override
    public void deleteGoodsreceipt(String goodsReceiptId) {
        if(!goodsreceiptRepository.existsById(goodsReceiptId))
            throw new AppException(ErrorCode.NOT_EXITS);

        goodsreceiptRepository.deleteById(goodsReceiptId);
    }

    @Override
    public GoodsreceiptDTO findGoodsreceiptById(String goodsReceiptId) {
        Goodsreceipt goodsreceipt = goodsreceiptRepository.findById(goodsReceiptId).orElseThrow(() -> new AppException(ErrorCode.NOT_EXITS));
        GoodsreceiptDTO goodsreceiptDTO =  modelMapper.map(goodsreceipt, GoodsreceiptDTO.class);
        goodsreceiptDTO.setEmployeeId(goodsreceipt.getEmployee().getEmployeeID());
        goodsreceiptDTO.setProductId(goodsreceipt.getProduct().getProductId());
        return goodsreceiptDTO;
    }
}
