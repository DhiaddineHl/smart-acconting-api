package com.wind.windrecruitmentapi.services;


import org.springframework.stereotype.Service;

@Service("validationService")
public interface ValidationService {
    void validateCandidacy(Integer candidacyId);

    void getAllValidations();

    void getValidationById(Integer id);
}
