package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.HRRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HRRecruiterRepository extends JpaRepository<HRRecruiter, Integer> {

    Optional<HRRecruiter> findHRRecruiterByEmail(String email);

    boolean existsByEmail(String email);

}
