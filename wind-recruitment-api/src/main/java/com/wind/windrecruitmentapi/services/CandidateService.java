package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("candidateService")
public interface CandidateService {
    Integer postCandidacy(CandidacyRequest request, String authenticationHeader);

    void uploadCandidacyFiles(Integer candidacyId, MultipartFile file);

    PageResponse<CandidacyResponse> getMyCandidacies(String authenticationHeader, int size, int number);
}
