package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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




}
