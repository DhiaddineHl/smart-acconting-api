package com.wind.windrecruitmentapi.utils.authentication;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    private String email;
    private String password;

}
