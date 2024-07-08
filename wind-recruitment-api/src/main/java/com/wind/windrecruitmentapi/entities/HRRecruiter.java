package com.wind.windrecruitmentapi.entities;

import jakarta.persistence.CascadeType;
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

    @OneToMany(
            mappedBy = "topicAuthor",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Topic> proposedTopics;

    @OneToMany(
            mappedBy = "hrRecruiter",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Validation> validations;

}
