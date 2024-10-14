package com.wind.windrecruitmentapi;

import com.wind.windrecruitmentapi.utils.files.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
@EnableAsync
@EnableConfigurationProperties(StorageProperties.class)
public class WindRecruitmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindRecruitmentApiApplication.class, args);
    }

}
