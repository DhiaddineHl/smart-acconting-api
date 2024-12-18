package com.wind.windrecruitmentapi.utils.invoice;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private String supplierId;
    private String supplierName;
    private String supplierAddress;
    private String invoiceNumber;
    private String invoiceDate;
    private String paymentMethod;
    private String inventoryRef;
    private String operatorName;
    private String receipt;
    private String customerRef;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String totalRaw;
    private String totalDiscount;
    private String totalTaxFree;
    private String total;
    private String totalString;

    private String invoiceType;
    private Integer ledgerId;

}
