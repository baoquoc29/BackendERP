package com.example.vinasoy.controller.sales;

import com.example.vinasoy.dto.sales.ApiResponse;
import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.service.sales.implement.InvoiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<?> findAllInvoice() {
        List<InvoiceDTO> invoices = invoiceService.findAllInvoice();
        ApiResponse<List<InvoiceDTO>> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoices);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findInvoiceById(@PathVariable("id") String id) {
        InvoiceDTO invoiceDTO = invoiceService.findInvoiceById(id.toUpperCase());
        ApiResponse<InvoiceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addInvoice(@RequestBody @Valid InvoiceDTO invoiceRequest) {
        InvoiceDTO invoiceResponse = invoiceService.addInvoice(invoiceRequest);
        ApiResponse<InvoiceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInvoice(@PathVariable("id") String invoiceId, @RequestBody @Valid InvoiceDTO invoiceDTO) {
        InvoiceDTO invoiceResponse = invoiceService.updateInvoice(invoiceId.toUpperCase(), invoiceDTO);
        ApiResponse<InvoiceDTO> apiResponse = new ApiResponse<>();
        apiResponse.setData(invoiceResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") String inoviceId) {
        invoiceService.deleteInvoice(inoviceId.toUpperCase());
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setData("Xoa thanh cong");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
