package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
