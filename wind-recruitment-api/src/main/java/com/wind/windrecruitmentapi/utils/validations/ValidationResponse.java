package com.wind.windrecruitmentapi.utils.validations;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Topic;

public record ValidationResponse(

        Integer id,
        Candidacy candidacy
) {
}
