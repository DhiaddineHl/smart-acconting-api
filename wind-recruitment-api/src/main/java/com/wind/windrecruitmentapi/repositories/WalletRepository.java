package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.User;
import com.wind.windrecruitmentapi.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    List<Wallet> findAllByOwner(User owner);

}
