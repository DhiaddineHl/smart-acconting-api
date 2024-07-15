package com.wind.windrecruitmentapi.utils.authentication;

import com.wind.windrecruitmentapi.entities.User;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String access_token;

}
