package com.wind.windrecruitmentapi.serviceImpl;

import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.repositories.*;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.InvoiceService;
import com.wind.windrecruitmentapi.utils.invoice.InvoiceRequest;
import com.wind.windrecruitmentapi.utils.invoice.InvoiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private LedgerRepository ledgerRepository;

    @Override
    public Integer addInvoice(InvoiceRequest request) {
        Invoice invoice = Invoice.builder()
                .supplierId(request.getSupplierId())
                .supplierName(request.getSupplierName())
                .supplierAddress(request.getSupplierAddress())
                .invoiceNumber(request.getInvoiceNumber())
                .invoiceDate(request.getInvoiceDate())
                .paymentMethod(request.getPaymentMethod())
                .inventoryRef(request.getInventoryRef())
                .operatorName(request.getOperatorName())
                .receipt(request.getReceipt())
                .customerRef(request.getCustomerRef())
                .customerId(request.getCustomerId())
                .customerName(request.getCustomerName())
                .customerAddress(request.getCustomerAddress())
                .totalRaw(request.getTotalRaw())
                .totalDiscount(request.getTotalDiscount())
                .totalTaxFree(request.getTotalTaxFree())
                .total(request.getTotal())
                .totalString(request.getTotalString())
                .build();

        Invoice savedInvoice = invoiceRepository.save(invoice); // Assume invoiceRepository exists

        createTransaction(
                savedInvoice.getId(),
                request.getInvoiceType(),
                request.getLedgerId()
        );

        return savedInvoice.getId();
    }

//    private User extractUserFromToken(String authHeader) {
//
//        String jwtToken = authHeader.substring(7);
//        String userName = jwtService.extractUsername(jwtToken);
//        return userRepository.findByEmail(userName).orElseThrow();
//    }

    public void createTransaction(
            Integer invoiceId,
            String invoiceType,
            Integer ledgerId
    ){
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow();
        InvoiceType type = InvoiceType.valueOf(invoiceType.toUpperCase());

        Transaction transaction = Transaction.builder()
                .invoice(invoice)
                .invoiceType(type)
                .build();

        String amount = invoice.getTotal();
        Ledger ledger = ledgerRepository.findById(ledgerId).orElseThrow();



        if (Objects.equals(invoice.getPaymentMethod(), "CASH")){
            if (type == InvoiceType.RECEIVED){
                ledger.setBalance(
                        ledger.getBalance() + Double.parseDouble(amount)
                );
            }else {
                ledger.setBalance(
                        ledger.getBalance() - Double.parseDouble(amount)
                );
            }
        }else {
            if (type == InvoiceType.RECEIVED){
                ledger.setBalance(
                        ledger.getBalance() + Double.parseDouble(amount)
                );
            }else {
                ledger.setBalance(
                        ledger.getBalance() - Double.parseDouble(amount)
                );
            }
        }
        transactionRepository.save(transaction);
        ledger.getTransactions().add(transaction);
        ledgerRepository.save(ledger);

    }

}
