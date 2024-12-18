package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Entity
public class BankAccountLedger extends Ledger {

    @OneToOne
    private BankAccount ledgerOf;

}
