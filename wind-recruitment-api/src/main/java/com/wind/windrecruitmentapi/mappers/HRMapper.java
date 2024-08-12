package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.HRRecruiter;
import com.wind.windrecruitmentapi.utils.employees.HRResponse;
import com.wind.windrecruitmentapi.utils.employees.TechnicalResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HRMapper implements Function<HRRecruiter, HRResponse> {
    @Override
    public HRResponse apply(HRRecruiter recruiter) {
        return new HRResponse(
                recruiter.getId(),
                recruiter.getFirst_name() + " " + recruiter.getLast_name(),
                recruiter.getEmail(),
                recruiter.getSpeciality(),
                recruiter.isAccountActivated()
        );
    }
}
