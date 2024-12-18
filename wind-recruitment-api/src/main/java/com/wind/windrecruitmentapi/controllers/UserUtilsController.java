package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.UserService;
import com.wind.windrecruitmentapi.utils.ledger.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserUtilsController {

    private final UserService userService;

//    @GetMapping("/wallets")
//    public ResponseEntity<List<WalletDTO>> getUserWallets(
//        @RequestHeader("Authorization") String authHeader
//    ){
//        return ResponseEntity.ok(userService.getUserWallets(authHeader));
//    }
//
//    @GetMapping("/bankAccounts")
//    public ResponseEntity<List<BankAccountDTO>> getUserBankAccounts(
//            @RequestHeader("Authorization") String authHeader
//    ){
//        return ResponseEntity.ok(userService.getUserBankAccounts(authHeader));
//    }
//
//    @GetMapping("/bankAccountLedgers")
//    public ResponseEntity<List<BankAccountLedgerDTO>> getUserBankAccountLedgers(
//            @RequestHeader("Authorization") String authHeader
//    ){
//        return ResponseEntity.ok(userService.getUserBankAccountLedgers(authHeader));
//    }
//
//    @GetMapping("walletLedgers")
//    public ResponseEntity<List<WalletLedgerDTO>> getUserWalletLedgers(
//            @RequestHeader("Authorization") String authHeader
//    ){
//        return ResponseEntity.ok(userService.getUserWalletLedgers(authHeader));
//    }

    @GetMapping("ledgers")
    public ResponseEntity<List<LedgerDTO>> getUserLedgers(
            @RequestHeader("Authorization") String authHeader
    ){
        return ResponseEntity.ok(userService.getUserLedgers(authHeader));
    }

    @PostMapping("ledgers")
    public ResponseEntity<Integer> createLedger(
            @RequestBody LedgerRequest request,
            @RequestHeader("Authorization") String authHeader
    ){
        return ResponseEntity.ok(userService.createLedger(request, authHeader));
    }

}
