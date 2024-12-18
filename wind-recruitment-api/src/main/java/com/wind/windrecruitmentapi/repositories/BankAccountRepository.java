package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.BankAccount;
import com.wind.windrecruitmentapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    List<BankAccount> findAllByOwner(User owner);

}
