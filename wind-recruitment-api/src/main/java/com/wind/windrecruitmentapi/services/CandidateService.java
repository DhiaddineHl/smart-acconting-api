package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.canddacies.CandidacyRequest;
import org.springframework.stereotype.Service;

@Service("candidateService")
public interface CandidateService {
    void postCandidacy(CandidacyRequest request, String authenticationHeader);
}
