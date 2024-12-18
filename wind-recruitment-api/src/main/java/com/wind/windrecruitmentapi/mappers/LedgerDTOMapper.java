package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Ledger;
import com.wind.windrecruitmentapi.utils.ledger.LedgerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LedgerDTOMapper implements Function<Ledger, LedgerDTO> {

    @Autowired
    private TransactionDTOMapper transactionDTOMapper;

    @Override
    public LedgerDTO apply(Ledger ledger) {
        return new LedgerDTO(
                ledger.getId(),
                ledger.getBalance(),
                ledger.getLedgerOfId(),
                ledger.getTransactions()
                        .stream()
                        .map(transactionDTOMapper)
                        .toList()
        );
    }
}
