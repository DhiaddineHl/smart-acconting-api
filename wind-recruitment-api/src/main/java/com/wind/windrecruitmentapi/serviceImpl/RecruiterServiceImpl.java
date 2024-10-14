package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.mappers.CandidacyMapper;
import com.wind.windrecruitmentapi.mappers.TopicMapper;
import com.wind.windrecruitmentapi.mappers.ValidationMapper;
import com.wind.windrecruitmentapi.repositories.*;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.RecruiterService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyStatus;
import com.wind.windrecruitmentapi.utils.topics.TopicRequest;
import com.wind.windrecruitmentapi.utils.topics.TopicResponse;
import com.wind.windrecruitmentapi.utils.validations.ValidationResponse;
import com.wind.windrecruitmentapi.utils.validations.ValidationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Service
@RequiredArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    //todo: handle exception

    private final TopicRepository repository;
    private final CandidaciesRepository candidaciesRepository;
    private final ValidationRepository validationRepository;
    private final HRRecruiterRepository hrRepository;
    private final TechnicalRecruiterRepository techRepository;
    private final TopicMapper mapper;
    private final CandidacyMapper candidacyMapper;
    private final ValidationMapper validationMapper;
    private final JWTService jwtService;

    public HRRecruiter findRecruiterWithToken(String authenticationHeader){
        String token = authenticationHeader.substring(7);
        String username = jwtService.extractUsername(token);

//        Token jwtToken = tokenRepository.findByToken(token).orElseThrow();
        return hrRepository.findHRRecruiterByEmail(username).orElseThrow(
                () -> new IllegalStateException("The user is not authorized to execute such an operation")
        );
    }
    public TechnicalRecruiter findTechRecruiterWithToken(String authenticationHeader){
        String token = authenticationHeader.substring(7);
        String username = jwtService.extractUsername(token);

//        Token jwtToken = tokenRepository.findByToken(token).orElseThrow();
        return techRepository.findTechnicalRecruiterByEmail(username).orElseThrow(
                () -> new IllegalStateException("The user is not authorized to execute such an operation")
        );
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
    public void validateCandidacyByHr(Integer candidacyId, String authenticationHeader) {

        Candidacy candidacy = candidaciesRepository.findById(candidacyId).orElseThrow();
        HRRecruiter hrRecruiter = findRecruiterWithToken(authenticationHeader);

        Locale locale = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());

        candidacy.setStatus(CandidacyStatus.HR_VALIDATED);
        candidaciesRepository.save(candidacy);

        Validation newValidation = Validation.builder()
                .candidacy(candidacy)
                .createdAt(date)
                .hrRecruiter(hrRecruiter)
                .status(ValidationStatus.HR_VALIDATED)
                .build();

        validationRepository.save(newValidation);

    }

    @Override
    public void validateCandidacyByTechnical(Integer candidacyId, String authenticationHeader) {
        Candidacy candidacy = candidaciesRepository.findById(candidacyId).orElseThrow();
        TechnicalRecruiter recruiter = findTechRecruiterWithToken(authenticationHeader);

        if (!candidacy.getStatus().equals(CandidacyStatus.HR_VALIDATED)){
            throw new IllegalStateException("This candidacy is not yet validated by the HR");
        }
        candidacy.setStatus(CandidacyStatus.TECH_VALIDATED);
        candidaciesRepository.save(candidacy);

        Validation validation = validationRepository.findValidationByCandidacy(candidacy)
                        .orElseThrow(()-> new RuntimeException("No validation found for this candidacy"));
        validation.setStatus(ValidationStatus.TECHNICAL_VALIDATED);
        validationRepository.save(validation);

        recruiter.getValidations().add(validation);
        techRepository.save(recruiter);

    }

    public PageResponse<ValidationResponse> getValidationResponse(Page<Validation> validations){

        var validationsResponses = validations.stream().map(validationMapper).toList();

        return new PageResponse<ValidationResponse>(
                validationsResponses,
                validations.getNumber(),
                validationsResponses.size(),
                validations.getTotalElements(),
                validations.getTotalPages(),
                validations.isFirst(),
                validations.isLast()
        );
    }

    @Override
    public PageResponse<ValidationResponse> getAllValidations(int size, int number) {

        Pageable pageable = PageRequest.of(number, size);
        Page<Validation> validations = validationRepository.findAll(pageable);

        return getValidationResponse(validations);
    }

    @Override
    public ValidationResponse getValidationById(Integer id) {
        return validationRepository.findById(id)
                .map(validationMapper)
                .orElseThrow();
    }

    @Override
    public PageResponse<ValidationResponse> getValidationsByRecruiter(String authorizationHeader, int size, int number) {

        String token = authorizationHeader.substring(7);
        String username = jwtService.extractUsername(token);

        Pageable pageable = PageRequest.of(number, size);


        if (hrRepository.existsByEmail(username)){
            HRRecruiter recruiter = hrRepository.findHRRecruiterByEmail(username)
                    .orElseThrow();
            Page<Validation> validations = validationRepository.findValidationByHrRecruiter(recruiter, pageable);
            return getValidationResponse(validations);
        } else if (techRepository.existsByEmail(username)) {
            TechnicalRecruiter recruiter = techRepository.findTechnicalRecruiterByEmail(username)
                    .orElseThrow();
            Page<Validation> validations = validationRepository.findValidationsByTechnicalRecruiter(recruiter, pageable);
            return getValidationResponse(validations);
        }else {
            throw new RuntimeException("The logged in user is not allowed to access such data");
        }

    }


}
