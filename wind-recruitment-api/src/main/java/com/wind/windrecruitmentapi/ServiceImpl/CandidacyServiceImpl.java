package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.mappers.CandidacyMapper;
import com.wind.windrecruitmentapi.repositories.CandidaciesRepository;
import com.wind.windrecruitmentapi.repositories.CandidateRepository;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.TopicRepository;
import com.wind.windrecruitmentapi.services.CandidacyService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.canddacies.CandidacyStatus;
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
public class CandidacyServiceImpl implements CandidacyService {

    private final CandidaciesRepository repository;
    private final TokenRepository tokenRepository;
    private final CandidateRepository candidateRepository;
    private final TopicRepository topicRepository;
    private final CandidacyMapper mapper;

    public Candidate findCandidateWithToken(String authenticationHeader){
        String token = authenticationHeader.substring(7);
        Token jwtToken = tokenRepository.findByToken(token).orElseThrow();
        return candidateRepository.findById(jwtToken.getUser().getId()).orElseThrow();
    }
    @Override
    public void postCandidacy(CandidacyRequest request, String authenticationHeader) {

        Locale locale = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());

        Topic topic = topicRepository.findById(request.topic_id()).orElseThrow();

        Candidacy candidacy = Candidacy.builder()
                .topic(topic)
                .candidate(findCandidateWithToken(authenticationHeader))
                .createdAt(date)
                .status(CandidacyStatus.PENDING)
                .build();

        repository.save(candidacy);

    }

    public PageResponse<CandidacyResponse> getCandidaciesResponse(Page<Candidacy> candidacies){

        var candidaciesResponses = candidacies.stream().map(mapper).toList();

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
        Page<Candidacy> candidacies = repository.findAll(pageable);

        return getCandidaciesResponse(candidacies);
    }

    @Override
    public CandidacyResponse getCandidacyById(Integer id) {
        return repository.findById(id).map(mapper).orElseThrow();
    }

    @Override
    public PageResponse<CandidacyResponse> getCandidaciesByCandidate(Integer candidateId) {
        return null;
    }
}
