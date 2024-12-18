package com.wind.windrecruitmentapi.utils.ledger;

import java.util.List;

public record LedgerDTO(
        Integer id,
        Double balance,
        String ledgerOf,
        List<TransactionDTO> transactions
) {
}
