package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/validations")
public class ValidationController {

    private final ValidationService validationService;

    @PostMapping("/{candidacyId}")
    public void validateCandidacy(
            @PathVariable("candidacyId") Integer candidacyId
    ){
        validationService.validateCandidacy(candidacyId);
    }

    @GetMapping
    public void getAllValidations(){
        validationService.getAllValidations();
    }

    @GetMapping("/{id}")
    public void getValidationById(
            @PathVariable("id") Integer id
    ){
        validationService.getValidationById(id);
    }

}
