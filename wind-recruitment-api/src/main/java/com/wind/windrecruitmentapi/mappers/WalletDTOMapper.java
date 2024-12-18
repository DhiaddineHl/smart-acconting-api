package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Wallet;
import com.wind.windrecruitmentapi.utils.ledger.WalletDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WalletDTOMapper implements Function<Wallet, WalletDTO> {
    @Override
    public WalletDTO apply(Wallet wallet) {
        return new WalletDTO(
                wallet.getId(),
                wallet.getWalletId()
        );
    }
}
