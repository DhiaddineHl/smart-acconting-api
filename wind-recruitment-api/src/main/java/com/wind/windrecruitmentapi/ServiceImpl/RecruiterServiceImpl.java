package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.mappers.CandidacyMapper;
import com.wind.windrecruitmentapi.mappers.TopicMapper;
import com.wind.windrecruitmentapi.repositories.*;
import com.wind.windrecruitmentapi.services.RecruiterService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    private final TopicRepository repository;
    private final CandidaciesRepository candidaciesRepository;
    private final TokenRepository tokenRepository;
    private final ValidationRepository validationRepository;
    private final HRRecruiterRepository hrRepository;
    private final TopicMapper mapper;
    private final CandidacyMapper candidacyMapper;

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

    public PageResponse<CandidacyResponse> getCandidaciesResponse(Page<Candidacy> candidacies){

        var candidaciesResponses = candidacies.stream().map(candidacyMapper).toList();

        return new PageResponse<CandidacyResponse>(
                candidaciesResponses,
                candidacies.getNumber(),
                candidaciesResponses.size(),
                candidacies.getTotalElements(),
                candidacies.getTotalPages(),
                candidacies.isFirst(),
                candidacies.isLast()
        );
    }

    @Override
    public PageResponse<CandidacyResponse> getAllCandidacies(int size, int number) {

        Pageable pageable = PageRequest.of(number, size);
        Page<Candidacy> candidacies = candidaciesRepository.findAll(pageable);

        return getCandidaciesResponse(candidacies);
    }

    @Override
    public CandidacyResponse getCandidacyById(Integer id) {
        return candidaciesRepository.findById(id).map(candidacyMapper).orElseThrow();
    }

    @Override
    public PageResponse<CandidacyResponse> getCandidaciesByCandidate(Integer candidateId) {
        return null;
    }

    @Override
    public void validateCandidacy(Integer candidacyId, String authenticationHeader) {

        Candidacy candidacy = candidaciesRepository.findById(candidacyId).orElseThrow();
        HRRecruiter hrRecruiter = findRecruiterWithToken(authenticationHeader);

        Locale locale = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());

        Validation newValidation = Validation.builder()
                .candidacy(candidacy)
                .createdAt(date)
                .hrRecruiter(hrRecruiter)
                .build();

        validationRepository.save(newValidation);

    }

    @Override
    public void getAllValidations() {

    }

    @Override
    public void getValidationById(Integer id) {

    }
}
