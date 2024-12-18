package com.wind.windrecruitmentapi.utils.authentication;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String ownerName;
    private String businessName;
    private String email;
    private String password;
    private String phoneNumber;

}
