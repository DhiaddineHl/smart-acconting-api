package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.Candidacy;
import com.wind.windrecruitmentapi.entities.Candidate;
import com.wind.windrecruitmentapi.entities.Token;
import com.wind.windrecruitmentapi.entities.Topic;
import com.wind.windrecruitmentapi.mappers.CandidacyMapper;
import com.wind.windrecruitmentapi.repositories.CandidaciesRepository;
import com.wind.windrecruitmentapi.repositories.CandidateRepository;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.TopicRepository;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.CandidateService;
import com.wind.windrecruitmentapi.utils.PageResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyRequest;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyResponse;
import com.wind.windrecruitmentapi.utils.candidacies.CandidacyStatus;
import com.wind.windrecruitmentapi.utils.files.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    //todo: handle exception

    private final CandidaciesRepository repository;
    private final TokenRepository tokenRepository;
    private final CandidateRepository candidateRepository;
    private final TopicRepository topicRepository;
    private final CandidaciesRepository candidaciesRepository;
    private final FileStorageService fileStorageService;
    private final CandidacyMapper candidacyMapper;
    private final JWTService jwtService;

    public Candidate findCandidateWithToken(String authenticationHeader){
        String token = authenticationHeader.substring(7);
        String username = jwtService.extractUsername(token);

//        Token jwtToken = tokenRepository.findByToken(token).orElseThrow();
//        return candidateRepository.findById(jwtToken.getUser().getId()).orElseThrow();
        return candidateRepository.findCandidateByEmail(username).orElseThrow();
    }
    @Override
    public Integer postCandidacy(CandidacyRequest request, String authenticationHeader) {

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

        return repository.save(candidacy).getId();

    }

    @Override
    public void uploadCandidacyFiles(Integer candidacyId, MultipartFile file) {
        Candidacy candidacy = candidaciesRepository.findById(candidacyId)
                .orElseThrow(() -> new RuntimeException("no candidacy found"));

        var candidacyFile = fileStorageService.saveFile(file, candidacyId);
        if (candidacyFile.isEmpty()){
            log.warn("no file saved");
        }

        candidacy.setFile_url(candidacyFile);
        candidaciesRepository.save(candidacy);
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
    public PageResponse<CandidacyResponse> getMyCandidacies(String authenticationHeader, int size, int number) {
        Pageable pageable = PageRequest.of(number, size);
        Candidate candidate = findCandidateWithToken(authenticationHeader);
        Page<Candidacy> candidacies = candidaciesRepository.findCandidaciesByCandidate(pageable, candidate);

        return getCandidaciesResponse(candidacies);
    }

}
