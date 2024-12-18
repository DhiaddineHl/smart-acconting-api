package com.wind.windrecruitmentapi.utils.ledger;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LedgerRequest {

    private String ledgerOf;
    private String type;

}
