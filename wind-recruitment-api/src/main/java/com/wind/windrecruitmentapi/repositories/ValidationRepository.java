package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.HRRecruiter;
import com.wind.windrecruitmentapi.entities.TechnicalRecruiter;
import com.wind.windrecruitmentapi.entities.Validation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    Optional<Validation> findValidationByCandidacy(Candidacy candidacy);

    Page<Validation> findValidationByHrRecruiter(HRRecruiter recruiter, Pageable pageable);


    @Query("""
        select recruiter.validations from TechnicalRecruiter recruiter
        where recruiter = :recruiter
""")
    Page<Validation> findValidationsByTechnicalRecruiter(TechnicalRecruiter recruiter, Pageable pageable);

}
