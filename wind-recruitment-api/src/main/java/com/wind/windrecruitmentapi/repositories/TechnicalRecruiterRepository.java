package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.TechnicalRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicalRecruiterRepository extends JpaRepository<TechnicalRecruiter, Integer> {

    Optional<TechnicalRecruiter> findTechnicalRecruiterByEmail(String email);
    boolean existsByEmail(String email);

}
