package com.wind.windrecruitmentapi.utils.candidacies;

import com.wind.windrecruitmentapi.entities.Candidate;
import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;

public record CandidacyResponse(
        Integer id,
        String candidate_full_name,
        TopicResponse topic,
//        byte[] file,
        String file_url,
        String file_name,
        String createdAt,
        String status

) {
}
