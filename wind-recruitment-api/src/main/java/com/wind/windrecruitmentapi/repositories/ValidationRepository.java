package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {
}
