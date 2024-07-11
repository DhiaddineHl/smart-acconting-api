package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.CandidacyService;
import com.wind.windrecruitmentapi.services.TopicService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hr")
public class HRController {

    private final TopicService topicService;
    private final CandidacyService candidacyService;

    @PostMapping("/topic")
    public void createTopic(
            @RequestBody TopicRequest request,
            @RequestHeader("Authorization") String authenticationHeader
    ){
        topicService.createTopic(request, authenticationHeader);
    }

    @PutMapping("/topic/{id}")
    public void updateTopic(
            @PathVariable("id") Integer id,
            @RequestBody TopicRequest request
    ){
        topicService.updateTopic(request, id);
    }

    @DeleteMapping("topic/{id}")
    public void deleteTopic(
            @PathVariable("id") Integer id
    ){
        topicService.deleteTopic(id);
    }

    @GetMapping("/topics")
    public ResponseEntity<PageResponse<TopicResponse>> getAllTopics(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(topicService.getAllTopics(size, number));
    }

    @GetMapping("topic/{id}")
    public ResponseEntity<TopicResponse> getTopicById(
            @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @GetMapping("/topicsByRecruiter")
    public ResponseEntity<PageResponse<TopicResponse>> getTopicByRecruiter(
            @RequestHeader("Authorization") String authenticationHeader,
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(topicService.getTopicsByRecruiter(authenticationHeader, size, number));
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
