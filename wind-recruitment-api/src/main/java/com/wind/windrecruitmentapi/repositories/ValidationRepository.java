package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    Optional<Validation> findValidationByCandidacy(Candidacy candidacy);

}
