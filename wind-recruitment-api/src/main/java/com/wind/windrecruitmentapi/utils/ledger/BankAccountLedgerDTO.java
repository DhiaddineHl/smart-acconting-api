package com.wind.windrecruitmentapi.utils.ledger;

import java.util.List;

public record BankAccountLedgerDTO(
        Integer id,
        String bankAccountId,
        List<TransactionDTO> transactions
) {
}
