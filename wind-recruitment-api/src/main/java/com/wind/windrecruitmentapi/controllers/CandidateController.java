package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/candidate")
@PreAuthorize("hasRole('CANDIDATE')")
@Slf4j
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/candidacy")
    @PreAuthorize("hasAuthority('candidate:create')")
    public Integer postCandidacy(
            @RequestBody CandidacyRequest request,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        return candidateService.postCandidacy(request, authenticationHeader);
    }

    @PostMapping(value = "/files/{candidacy_id}", consumes = "multipart/form-data")
    @PreAuthorize("hasAuthority('candidate:create')")
    public void uploadCandidacyFiles(
            @PathVariable("candidacy_id") Integer candidacy_id,
            @RequestPart("file") MultipartFile file
    ){
        log.warn("received the files and started the method execution");
        candidateService.uploadCandidacyFiles(candidacy_id, file);
    }

    @GetMapping("/myCandidacies")
    @PreAuthorize("hasAuthority('candidate:read')")
    public ResponseEntity<PageResponse<CandidacyResponse>> getMyCandidacies(
            @RequestHeader("Authorization") String authenticationHeader,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(candidateService.getMyCandidacies(authenticationHeader, size, number));
    }

}
