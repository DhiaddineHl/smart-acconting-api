package com.wind.windrecruitmentapi.utils.authentication;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String access_token;

}
