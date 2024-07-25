package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TopicMapper implements Function<Topic, TopicResponse> {
    @Override
    public TopicResponse apply(Topic topic) {
        return new TopicResponse(
                topic.getId(),
                topic.getName(),
                topic.getDescription(),
                topic.getDuration(),
                topic.getRequirements()
        );
    }
}
