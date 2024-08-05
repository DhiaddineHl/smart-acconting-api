package com.wind.windrecruitmentapi.utils.validations;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;

public record ValidationResponse(

        Integer id,
        CandidacyResponse candidacy,
        String validatedAt
) {
}
