package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CandidacyMapper implements Function<Candidacy, CandidacyResponse> {
    @Override
    public CandidacyResponse apply(Candidacy candidacy) {
        return null;
    }
}
