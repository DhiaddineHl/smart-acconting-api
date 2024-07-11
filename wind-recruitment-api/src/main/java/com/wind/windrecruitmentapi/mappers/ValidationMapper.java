package com.wind.windrecruitmentapi.mappers;

import com.wind.windrecruitmentapi.entities.Validation;
import com.wind.windrecruitmentapi.utils.validations.ValidationResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ValidationMapper implements Function<Validation, ValidationResponse> {
    @Override
    public ValidationResponse apply(Validation validation) {
        return new ValidationResponse(
                validation.getId(),
                validation.getCandidacy()
        );
    }
}
