package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Validation;
import com.wind.windrecruitmentapi.utils.validations.ValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ValidationMapper implements Function<Validation, ValidationResponse> {

    private final CandidacyMapper candidacyMapper;

    @Override
    public ValidationResponse apply(Validation validation) {
        return new ValidationResponse(
                validation.getId(),
                candidacyMapper.apply(validation.getCandidacy()),
                validation.getCreatedAt()
        );
    }
}
