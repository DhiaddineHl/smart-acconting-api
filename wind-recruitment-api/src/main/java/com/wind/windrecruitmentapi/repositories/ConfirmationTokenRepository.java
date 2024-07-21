package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

    ConfirmationToken findByToken(String token);

}
