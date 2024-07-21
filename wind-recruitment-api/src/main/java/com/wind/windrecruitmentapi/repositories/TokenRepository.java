package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

//    Optional<Token> findByToken(String token);

    Token findByToken(String token);



}
