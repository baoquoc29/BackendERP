package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.CustomerDTO;
import com.example.vinasoy.dto.sales.InvoiceDTO;

import java.util.List;

public interface IInvoiceService {
    List<InvoiceDTO> findAllInvoice();
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);
    InvoiceDTO updateInvoice(String invoiceId, InvoiceDTO invoiceDTO);
    void deleteInvoice(String invoiceId);
    InvoiceDTO findInvoiceById(String invoiceId);
}
