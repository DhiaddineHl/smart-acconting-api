package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Ledger;
import com.wind.windrecruitmentapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerRepository extends JpaRepository<Ledger, Integer> {

    List<Ledger> findAllByOwner(User owner);

}
