package com.wind.windrecruitmentapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(builderMethodName = "hrRecruiterBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HRRecruiter extends User{

    private String company;

    @OneToMany
    private List<Topic> proposedTopics;

    @OneToMany
    private List<Validation> validations;

}
