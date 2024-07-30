package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.files.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CandidacyMapper implements Function<Candidacy, CandidacyResponse> {

    private final TopicMapper topicMapper;
    @Override
    public CandidacyResponse apply(Candidacy candidacy) {
        return new CandidacyResponse(
                candidacy.getId(),
                candidacy.getCandidate().getFirst_name() + " " + candidacy.getCandidate().getLast_name(),
                topicMapper.apply(candidacy.getTopic()),
                FileUtils.readFileFromLocation(candidacy.getFile_url()),
                candidacy.getCreatedAt(),
                candidacy.getStatus().name().toLowerCase()
        );
    }
}
