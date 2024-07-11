package com.wind.windrecruitmentapi.controllers;

import com.wind.windrecruitmentapi.services.CandidacyService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidacies")
public class CandidacyController {

    private final CandidacyService candidacyService;

    @PostMapping
    public void postCandidacy(
            @RequestBody CandidacyRequest request,
            @RequestHeader("Authorization") String authenticationHeader
            ){
        candidacyService.postCandidacy(request, authenticationHeader);
    }

    @GetMapping
    public ResponseEntity<PageResponse<CandidacyResponse>> getAllCandidacies(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(candidacyService.getAllCandidacies(
                size, number
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidacyResponse> getCandidacyById(
            @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(candidacyService.getCandidacyById(id));
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<PageResponse<CandidacyResponse>> getCandidaciesByCandidate(
            @PathVariable("candidateId") Integer candidateId
    ){
        return ResponseEntity.ok(candidacyService.getCandidaciesByCandidate(candidateId));
    }



}
