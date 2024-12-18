package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.BankAccount;
import com.wind.windrecruitmentapi.utils.ledger.BankAccountDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BankAccountDTOMapper implements Function<BankAccount, BankAccountDTO> {
    @Override
    public BankAccountDTO apply(BankAccount bankAccount) {
        return new BankAccountDTO(
                bankAccount.getId(),
                bankAccount.getAccountId()
        );
    }
}
