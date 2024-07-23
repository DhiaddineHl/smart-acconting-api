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
import com.wind.windrecruitmentapi.utils.files.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    private final CandidaciesRepository candidaciesRepository;
    private final FileStorageService fileStorageService;

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

    @Override
    public void uploadCandidacyFiles(Integer candidacyId, MultipartFile file) {
        Candidacy candidacy = candidaciesRepository.findById(candidacyId)
                .orElseThrow();
        var candidacyFile = fileStorageService.saveFile(file, candidacyId);
        candidacy.setFile_url(candidacyFile);
        candidaciesRepository.save(candidacy);
    }

}
