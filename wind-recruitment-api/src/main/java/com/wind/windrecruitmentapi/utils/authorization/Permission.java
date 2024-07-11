package com.wind.windrecruitmentapi.utils.authorization;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@RequiredArgsConstructor
public enum Permission {


    MANAGER_READ("manager:read"),
    MANAGER_CREATE("manager:create"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_DELETE("manager:delete"),

    RECRUITER_READ("recruiter:read"),
    RECRUITER_CREATE("recruiter:create"),
    RECRUITER_UPDATE("recruiter:update"),
    RECRUITER_DELETE("recruiter:delete"),

    CANDIDATE_READ("candidate:read"),
    CANDIDATE_CREATE("candidate:create"),
    CANDIDATE_UPDATE("candidate:update"),
    CANDIDATE_DELETE("candidate:delete");



    private final String permission;

}
