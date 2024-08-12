package com.wind.windrecruitmentapi.utils.employees;

public record TechnicalResponse(
        Integer id,
        String full_name,
        String email,
        String speciality,
        boolean account_state
) {
}
