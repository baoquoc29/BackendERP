package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.dto.sales.InvoicedetailsDTO;
import com.example.vinasoy.service.sales.implement.InvoiceDetailService;
import com.example.vinasoy.service.sales.implement.InvoiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/invoiceDetails")
public class InvoiceDetailController {
    private final InvoiceDetailService invoiceDetailService;

    @GetMapping
    public ResponseEntity<?> findAllInvoiceDetail() {
        List<InvoicedetailsDTO> invoices = invoiceDetailService.findAllInvoiceDetail();
        ApiResponse<List<InvoicedetailsDTO> > apiResponse = new ApiResponse<>();
        apiResponse.setData(invoices);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findInvoiceDetailById(@PathVariable("id") String id) {
        InvoicedetailsDTO invoiceDTO = invoiceDetailService.findInvoiceDetailById(id.toUpperCase());
        ApiResponse<InvoicedetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addInvoiceDetail(@RequestBody @Valid InvoicedetailsDTO invoiceRequest) {
        InvoicedetailsDTO invoiceResponse = invoiceDetailService.addInvoiceDetail(invoiceRequest);
        ApiResponse<InvoicedetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInvoiceDetail(@PathVariable("id") String invoiceId, @RequestBody @Valid InvoicedetailsDTO invoiceDTO) {
        InvoicedetailsDTO invoiceResponse = invoiceDetailService.updateInvoiceDetail(invoiceId.toUpperCase(), invoiceDTO);
        ApiResponse<InvoicedetailsDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoiceDetail(@PathVariable("id") String inoviceId) {
        invoiceDetailService.deleteInvoiceDetail(inoviceId.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
