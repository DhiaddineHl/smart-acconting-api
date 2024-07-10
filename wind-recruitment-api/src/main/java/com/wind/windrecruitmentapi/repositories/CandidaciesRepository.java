package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Candidacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaciesRepository extends JpaRepository<Candidacy, Integer> {
}
