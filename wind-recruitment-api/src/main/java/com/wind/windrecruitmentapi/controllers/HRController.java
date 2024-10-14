package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.RecruiterService;
import com.wind.windrecruitmentapi.services.StorageService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import com.wind.windrecruitmentapi.utils.validations.ValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hr")
@PreAuthorize("hasRole('RECRUITER')")
public class HRController {

    //todo: add the controllers of searching by name
    //todo : add the cv skills extracting feature
    //todo: candidacy rejection feature

    private final RecruiterService recruiterService;
    private final StorageService storageService;

    @PostMapping("/topic")
    @PreAuthorize("hasAuthority('recruiter:create')")
    public void createTopic(
            @RequestBody TopicRequest request,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        recruiterService.createTopic(request, authenticationHeader);
    }

    @PutMapping("/topic/{id}")
    @PreAuthorize("hasAuthority('recruiter:update')")
    public void updateTopic(
            @PathVariable("id") Integer id,
            @RequestBody TopicRequest request
    ){
        recruiterService.updateTopic(request, id);
    }

    @DeleteMapping("topic/{id}")
    @PreAuthorize("hasAuthority('recruiter:delete')")
    public void deleteTopic(
            @PathVariable("id") Integer id
    ){
        recruiterService.deleteTopic(id);
    }

    @GetMapping("/topics")
    @PreAuthorize("hasAnyAuthority('recruiter:read', 'candidate:read')")
    public ResponseEntity<PageResponse<TopicResponse>> getAllTopics(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(recruiterService.getAllTopics(size, number));
    }

    @GetMapping("topic/{id}")
    @PreAuthorize("hasAnyAuthority('recruiter:read', 'candidate:read')")
    public ResponseEntity<TopicResponse> getTopicById(
            @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(recruiterService.getTopicById(id));
    }

    @GetMapping("/topicsByRecruiter")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<PageResponse<TopicResponse>> getTopicByRecruiter(
            @RequestHeader("Authorization") String authenticationHeader,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(recruiterService.getTopicsByRecruiter(authenticationHeader, size, number));
    }

    @GetMapping("/candidacies")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<PageResponse<CandidacyResponse>> getAllCandidacies(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(recruiterService.getAllCandidacies(
                size, number
        ));
    }

    @GetMapping("/candidacies/{id}")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<CandidacyResponse> getCandidacyById(
            @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(recruiterService.getCandidacyById(id));
    }

    @GetMapping("candidacies/candidate/{candidateId}")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<PageResponse<CandidacyResponse>> getCandidaciesByCandidate(
            @PathVariable("candidateId") Integer candidateId
    ){
        return ResponseEntity.ok(recruiterService.getCandidaciesByCandidate(candidateId));
    }

    @GetMapping("/candidacies/getFile/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable("filename") String filename) {
        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        String contentDisposition = "attachment; filename=\"" + file.getFilename() + "\"";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(file);
    }

    @PostMapping("validate-candidacy-hr/{candidacyId}")
    @PreAuthorize("hasAuthority('recruiter:create')")
    public void validateCandidacyByHR(
            @PathVariable("candidacyId") Integer candidacyId,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        recruiterService.validateCandidacyByHr(candidacyId, authenticationHeader);
    }

    @PutMapping("validate-candidacy-tech/{candidacyId}")
    @PreAuthorize("hasAuthority('recruiter:update')")
    public void validateCandidacyByTechnical(
            @PathVariable("candidacyId") Integer candidacyId,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        recruiterService.validateCandidacyByTechnical(candidacyId, authenticationHeader);
    }

    @GetMapping("/validations")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<PageResponse<ValidationResponse>> getAllValidations(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(recruiterService.getAllValidations(size, number));
    }

    @GetMapping("validations/{id}")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<ValidationResponse> getValidationById(
            @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(recruiterService.getValidationById(id));
    }

    @GetMapping("/validationsByRecruiter")
    @PreAuthorize("hasAuthority('recruiter:read')")
    public ResponseEntity<PageResponse<ValidationResponse>> getValidationsByRecruiter(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number,
            @RequestHeader("Authorization") String authorizationHeader
    ){
        return ResponseEntity.ok(recruiterService.getValidationsByRecruiter(authorizationHeader, size, number));
    }

}
