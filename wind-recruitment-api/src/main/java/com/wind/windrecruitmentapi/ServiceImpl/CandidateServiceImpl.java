package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Candidate;
import com.wind.windrecruitmentapi.entities.Token;
import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.repositories.CandidaciesRepository;
import com.wind.windrecruitmentapi.repositories.CandidateRepository;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.TopicRepository;
import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidaciesRepository repository;
    private final TokenRepository tokenRepository;
    private final CandidateRepository candidateRepository;
    private final TopicRepository topicRepository;
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
}
