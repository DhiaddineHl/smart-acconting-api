package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidate")
@PreAuthorize("hasRole('CANDIDATE')")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/candidacy")
    @PreAuthorize("hasAuthority('candidate:create')")
    public void postCandidacy(
            @RequestBody CandidacyRequest request,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        candidateService.postCandidacy(request, authenticationHeader);
    }

    @PostMapping(value = "/files/{candidacy-id}", consumes = "multipart/form-data")
    @PreAuthorize("hasAuthority('candidate:create')")
    public void uploadCandidacyFiles(
            @PathVariable("candidacy-id") Integer candidacyId,
            @Parameter()
            @RequestPart("file") MultipartFile file
    ){
        candidateService.uploadCandidacyFiles(candidacyId, file);
    }

}
