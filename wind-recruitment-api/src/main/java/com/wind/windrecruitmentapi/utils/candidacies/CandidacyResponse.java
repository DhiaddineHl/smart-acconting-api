package com.wind.windrecruitmentapi.utils.candidacies;

import com.wind.windrecruitmentapi.entities.Candidate;
import com.wind.windrecruitmentapi.entities.Topic;

public record CandidacyResponse(
        Integer id,
        Candidate candidate,
        Topic topic,
        byte[] file,
        String createdAt,
        String status

) {
}
