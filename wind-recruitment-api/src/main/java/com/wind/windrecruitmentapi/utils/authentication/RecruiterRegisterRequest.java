package com.wind.windrecruitmentapi.utils.authentication;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterRegisterRequest {

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private String recruiter_type;
    private String speciality;
    private String company;

}
