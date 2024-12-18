package com.wind.windrecruitmentapi.utils.authorization;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@RequiredArgsConstructor
public enum Permission {


    BUSINESS_READ("business:read"),
    BUSINESS_CREATE("business:create"),
    BUSINESS_UPDATE("business:update"),
    BUSINESS_DELETE("business:delete");




    private final String permission;

}
