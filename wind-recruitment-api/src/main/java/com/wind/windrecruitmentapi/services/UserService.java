package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.entities.Ledger;
import com.wind.windrecruitmentapi.utils.ledger.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public interface UserService {

//    List<WalletDTO> getUserWallets(String authHeader);
//
//    List<BankAccountDTO> getUserBankAccounts(String authHeader);
//
//    List<BankAccountLedgerDTO> getUserBankAccountLedgers(String authHeader);
//
//    List<WalletLedgerDTO> getUserWalletLedgers(String authHeader);

    List<LedgerDTO> getUserLedgers(String authHeader);

    Integer createLedger(LedgerRequest request, String authHeader);
}
