package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

}
