package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import org.springframework.stereotype.Service;

@Service("candidacyService")
public interface CandidacyService {
    void postCandidacy(CandidacyRequest request, String authenticationHeader);

    PageResponse<CandidacyResponse> getAllCandidacies(int size, int number);

    CandidacyResponse getCandidacyById(Integer id);

    PageResponse<CandidacyResponse> getCandidaciesByCandidate(Integer candidateId);
}
