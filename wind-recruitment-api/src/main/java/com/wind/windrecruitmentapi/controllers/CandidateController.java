package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/candidacy")
    public void postCandidacy(
            @RequestBody CandidacyRequest request,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        candidateService.postCandidacy(request, authenticationHeader);
    }

}
