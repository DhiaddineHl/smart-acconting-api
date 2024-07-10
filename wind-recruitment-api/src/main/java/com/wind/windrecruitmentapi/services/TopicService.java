package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import org.springframework.stereotype.Service;

@Service("topicService")
public interface TopicService {
    void createTopic(TopicRequest request, String authenticationHeader);

    void updateTopic(TopicRequest request);

    void deleteTopic(Integer id);

    PageResponse<TopicResponse> getAllTopics(int size, int number);

    TopicResponse getTopicById(Integer id);

    PageResponse<TopicResponse> getTopicsByRecruiter(String authenticationHeader, int size, int number);
}