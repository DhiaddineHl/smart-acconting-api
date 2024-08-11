package com.wind.windrecruitmentapi.utils.authentication;

public record EmployeeResponse(

        Integer id,
        String full_name,
        String email,
        String speciality,
        boolean account_state

) {
}
