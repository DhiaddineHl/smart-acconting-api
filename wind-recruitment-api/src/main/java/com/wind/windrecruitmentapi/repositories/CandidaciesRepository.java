package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaciesRepository extends JpaRepository<Candidacy, Integer> {

    Page<Candidacy> findCandidaciesByCandidate(Pageable pageable, Candidate candidate);

}
