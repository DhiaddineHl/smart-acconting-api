package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.files.FileUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CandidacyMapper implements Function<Candidacy, CandidacyResponse> {
    @Override
    public CandidacyResponse apply(Candidacy candidacy) {
        return new CandidacyResponse(
                candidacy.getId(),
                candidacy.getCandidate(),
                candidacy.getTopic(),
                FileUtils.readFileFromLocation(candidacy.getFile_url()),
                candidacy.getCreatedAt(),
                candidacy.getStatus().name().toLowerCase()
        );
    }
}
