package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.InvoiceService;
import com.wind.windrecruitmentapi.utils.invoice.InvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Integer> addInvoice(
        @RequestBody InvoiceRequest request
    ){
        return ResponseEntity.ok(invoiceService.addInvoice(request));
    }

}
