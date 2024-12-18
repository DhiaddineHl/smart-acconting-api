package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Transaction;
import com.wind.windrecruitmentapi.utils.ledger.TransactionDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionDTOMapper implements Function<Transaction, TransactionDTO> {
    @Override
    public TransactionDTO apply(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getInvoice().getId(),
                transaction.getInvoiceType().toString()
        );
    }
}
