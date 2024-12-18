package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.BankAccountLedger;
import com.wind.windrecruitmentapi.utils.ledger.BankAccountLedgerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BankAccountLedgerDTOMapper implements Function<BankAccountLedger, BankAccountLedgerDTO> {

    @Autowired
    private TransactionDTOMapper transactionDTOMapper;

    @Override
    public BankAccountLedgerDTO apply(BankAccountLedger bankAccountLedger) {
        return new BankAccountLedgerDTO(
                bankAccountLedger.getId(),
                bankAccountLedger.getLedgerOf().getAccountId(),
                bankAccountLedger.getTransactions()
                        .stream()
                        .map(transactionDTOMapper)
                        .toList()

        );
    }
}
