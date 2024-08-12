package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.TechnicalRecruiter;
import com.wind.windrecruitmentapi.utils.employees.TechnicalResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class TechMapper implements Function<TechnicalRecruiter, TechnicalResponse> {
    @Override
    public TechnicalResponse apply(TechnicalRecruiter recruiter) {
        return new TechnicalResponse(
                recruiter.getId(),
                recruiter.getFirst_name() + " " + recruiter.getLast_name(),
                recruiter.getEmail(),
                recruiter.getSpeciality(),
                recruiter.isAccountActivated()
        );
    }
}
