package com.wind.windrecruitmentapi.utils.ledger;

import java.util.List;

public record WalletLedgerDTO(
        Integer id,
        String walletId,
        List<TransactionDTO> transactions
) {
}
