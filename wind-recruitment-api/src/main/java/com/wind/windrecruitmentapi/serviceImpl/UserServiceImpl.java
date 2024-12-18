package com.wind.windrecruitmentapi.serviceImpl;

import com.wind.windrecruitmentapi.entities.BankAccountLedger;
import com.wind.windrecruitmentapi.entities.Ledger;
import com.wind.windrecruitmentapi.entities.User;
import com.wind.windrecruitmentapi.mappers.*;
import com.wind.windrecruitmentapi.repositories.*;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.UserService;
import com.wind.windrecruitmentapi.utils.ledger.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private LedgerRepository ledgerRepository;
    @Autowired
    private LedgerDTOMapper ledgerDTOMapper;

//    @Autowired
//    private WalletRepository walletRepository;
//    @Autowired
//    private WalletDTOMapper walletDTOMapper;
//    @Autowired
//    private WalletLedgerRepository walletLedgerRepository;
//    @Autowired
//    private WalletLedgerDTOMapper walletLedgerDTOMapper;
//
//    @Autowired
//    private BankAccountRepository bankAccountRepository;
//    @Autowired
//    private BankAccountDTOMapper bankAccountDTOMapper;
//    @Autowired
//    private BankAccountLedgerRepository bankAccountLedgerRepository;
//    @Autowired
//    private BankAccountLedgerDTOMapper bankAccountLedgerDTOMapper;

    public User extractUserFromToken(String authHeader){
        String jwt = authHeader.substring(7);
        String userName = jwtService.extractUsername(jwt);

        return userRepository.findByEmail(userName)
                .orElseThrow();

    }

//    @Override
//    public List<WalletDTO> getUserWallets(String authHeader) {
//
//        User user = extractUserFromToken(authHeader);
//        return walletRepository.findAllByOwner(user)
//                .stream()
//                .map(walletDTOMapper)
//                .toList();
//    }
//
//    @Override
//    public List<BankAccountDTO> getUserBankAccounts(String authHeader) {
//
//        User user = extractUserFromToken(authHeader);
//        return bankAccountRepository.findAllByOwner(user)
//                .stream()
//                .map(bankAccountDTOMapper)
//                .toList();
//    }
//
//    @Override
//    public List<BankAccountLedgerDTO> getUserBankAccountLedgers(String authHeader) {
//
//        User user =  extractUserFromToken(authHeader);
//        return bankAccountLedgerRepository.findAllByOwner(user)
//                .stream()
//                .map(bankAccountLedgerDTOMapper)
//                .toList();
//    }
//
//    @Override
//    public List<WalletLedgerDTO> getUserWalletLedgers(String authHeader) {
//        User user = extractUserFromToken(authHeader);
//        return walletLedgerRepository.findAllByOwner(user)
//                .stream()
//                .map(walletLedgerDTOMapper)
//                .toList();
//    }

    @Override
    public List<LedgerDTO> getUserLedgers(String authHeader) {

        User user = extractUserFromToken(authHeader);

        return ledgerRepository.findAllByOwner(user)
                .stream()
                .map(ledgerDTOMapper)
                .toList();

    }

    @Override
    public Integer createLedger(LedgerRequest request, String authHeader) {

        User user = extractUserFromToken(authHeader);

        Ledger ledger = Ledger.builder()
                .ledgerOfId(request.getLedgerOf())
                .balance(0.0)
                .owner(user)
                .type(LedgerType.valueOf(request.getType().toUpperCase()))
                .transactions(new ArrayList<>())
                .build();

        return ledgerRepository.save(ledger).getId();
    }

}
