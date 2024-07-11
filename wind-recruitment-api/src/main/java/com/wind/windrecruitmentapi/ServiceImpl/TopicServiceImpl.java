package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.HRRecruiter;
import com.wind.windrecruitmentapi.entities.Token;
import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.mappers.TopicMapper;
import com.wind.windrecruitmentapi.repositories.HRRecruiterRepository;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.TopicRepository;
import com.wind.windrecruitmentapi.services.TopicService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;
    private final TokenRepository tokenRepository;
    private final HRRecruiterRepository hrRepository;
    private final TopicMapper mapper;

    public HRRecruiter findRecruiterWithToken(String authenticationHeader){
        String token = authenticationHeader.substring(7);
        Token jwtToken = tokenRepository.findByToken(token).orElseThrow();
        return hrRepository.findById(jwtToken.getUser().getId()).orElseThrow();
    }
    @Override
    public void createTopic(TopicRequest request, String authenticationHeader) {

        HRRecruiter recruiter = findRecruiterWithToken(authenticationHeader);

        Topic newTopic = Topic.builder()
                .name(request.getName())
                .description(request.getDescription())
                .duration(request.getDuration())
                .topicAuthor(recruiter)
                .requirements(request.getRequirements())
                .build();

        repository.save(newTopic);

    }

    @Override
    public void updateTopic(TopicRequest request, Integer id) {

    }

    @Override
    public void deleteTopic(Integer id) {
        repository.deleteById(id);
    }

    public PageResponse<TopicResponse> getTopicResponse(Page<Topic> topics){

        var topicResponses = topics.stream().map(mapper).toList();

        return new PageResponse<TopicResponse>(
                topicResponses,
                topics.getNumber(),
                topicResponses.size(),
                topics.getTotalElements(),
                topics.getTotalPages(),
                topics.isFirst(),
                topics.isLast()
        );
    }

    @Override
    public PageResponse<TopicResponse> getAllTopics(int size, int number) {

        Pageable pageable = PageRequest.of(number, size);
        Page<Topic> topics = repository.findAll(pageable);

        return getTopicResponse(topics);
    }

    @Override
    public TopicResponse getTopicById(Integer id) {
        return repository.findById(id).map(mapper).orElseThrow();
    }

    @Override
    public PageResponse<TopicResponse> getTopicsByRecruiter(String authenticationHeader, int size, int number) {

        HRRecruiter recruiter = findRecruiterWithToken(authenticationHeader);

        Pageable pageable = PageRequest.of(number, size);
        Page<Topic> topics = repository.findTopicsByTopicAuthor(pageable, recruiter);

        return getTopicResponse(topics);
    }
}
