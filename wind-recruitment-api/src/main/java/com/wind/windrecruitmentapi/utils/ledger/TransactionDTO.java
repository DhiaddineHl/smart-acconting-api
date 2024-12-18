package com.wind.windrecruitmentapi.utils.ledger;

public record TransactionDTO(
        Integer id,
        Integer invoiceId,
        String invoiceType
) {
}
