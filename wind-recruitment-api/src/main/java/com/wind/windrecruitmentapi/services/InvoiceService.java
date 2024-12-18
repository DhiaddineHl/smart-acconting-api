package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.invoice.InvoiceRequest;
import org.springframework.stereotype.Service;

@Service("invoiceService")
public interface InvoiceService {
    Integer addInvoice(InvoiceRequest request);
}
