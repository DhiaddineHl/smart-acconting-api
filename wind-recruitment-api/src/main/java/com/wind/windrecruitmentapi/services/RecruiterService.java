package com.wind.windrecruitmentapi.services;


import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import org.springframework.stereotype.Service;

@Service("recruiterService")
public interface RecruiterService {

    void createTopic(TopicRequest request, String authenticationHeader);

    void updateTopic(TopicRequest request, Integer id);

    void deleteTopic(Integer id);

    PageResponse<TopicResponse> getAllTopics(int size, int number);

    TopicResponse getTopicById(Integer id);

    PageResponse<TopicResponse> getTopicsByRecruiter(String authenticationHeader, int size, int number);

    PageResponse<CandidacyResponse> getAllCandidacies(int size, int number);

    CandidacyResponse getCandidacyById(Integer id);

    PageResponse<CandidacyResponse> getCandidaciesByCandidate(Integer candidateId);

    void validateCandidacy(Integer candidacyId);

    void getAllValidations();

    void getValidationById(Integer id);
}
