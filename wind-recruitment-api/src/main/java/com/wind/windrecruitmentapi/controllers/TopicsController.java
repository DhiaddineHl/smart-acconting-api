package com.wind.windrecruitmentapi.controllers;

import com.wind.windrecruitmentapi.services.TopicService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/topics")
public class TopicsController {

    private final TopicService topicService;

    @PostMapping
    public void createTopic(
            @RequestBody TopicRequest request,
            @RequestHeader String authenticationHeader
    ){
        topicService.createTopic(request, authenticationHeader);
    }

    @PutMapping
    public void updateTopic(
        @RequestBody TopicRequest request
    ){
        topicService.updateTopic(request);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(
        @PathVariable("id") Integer id
    ){
        topicService.deleteTopic(id);
    }

    @GetMapping
    public ResponseEntity<PageResponse<TopicResponse>> getAllTopics(
            @RequestParam(name = "size", defaultValue = "10", required = false) int size,
            @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(topicService.getAllTopics(size, number));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> getTopicById(
        @PathVariable("id") Integer id
    ){
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @GetMapping("/recruiter")
    public ResponseEntity<PageResponse<TopicResponse>> getTopicByRecruiter(
        @RequestHeader String authenticationHeader,
        @RequestParam(name = "size", defaultValue = "10", required = false) int size,
        @RequestParam(name = "number", defaultValue = "0", required = false) int number
    ){
        return ResponseEntity.ok(topicService.getTopicsByRecruiter(authenticationHeader, size, number));
    }


}
