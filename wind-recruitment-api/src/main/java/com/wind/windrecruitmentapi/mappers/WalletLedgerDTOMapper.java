package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.WalletLedger;
import com.wind.windrecruitmentapi.utils.ledger.WalletLedgerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WalletLedgerDTOMapper implements Function<WalletLedger, WalletLedgerDTO> {

    @Autowired
    private TransactionDTOMapper transactionDTOMapper;

    @Override
    public WalletLedgerDTO apply(WalletLedger walletLedger) {
        return new WalletLedgerDTO(
                walletLedger.getId(),
                walletLedger.getLedgerOf().getWalletId(),
                walletLedger.getTransactions()
                        .stream()
                        .map(transactionDTOMapper)
                        .toList()

        );
    }
}
