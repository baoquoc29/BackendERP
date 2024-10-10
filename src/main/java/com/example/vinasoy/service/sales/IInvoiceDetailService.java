package com.example.vinasoy.service.sales;

import com.example.vinasoy.dto.sales.InvoiceDTO;
import com.example.vinasoy.dto.sales.InvoicedetailsDTO;

import java.util.List;

public interface IInvoiceDetailService {
    List<InvoicedetailsDTO> findAllInvoiceDetail();
    InvoicedetailsDTO addInvoiceDetail(InvoicedetailsDTO invoicedetailsDTO);
    InvoicedetailsDTO updateInvoiceDetail(String invoiceDetailId, InvoicedetailsDTO invoicedetailsDTO);
    void deleteInvoiceDetail(String invoiceDetailId);
    InvoicedetailsDTO findInvoiceDetailById(String invoiceDetailId);
}
