package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("candidateService")
public interface CandidateService {
    Integer postCandidacy(CandidacyRequest request, String authenticationHeader);


    void uploadCandidacyFiles(Integer candidacyId, MultipartFile file);
}
