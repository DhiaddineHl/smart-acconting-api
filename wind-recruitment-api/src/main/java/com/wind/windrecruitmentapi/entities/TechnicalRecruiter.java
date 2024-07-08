package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(builderMethodName = "technicalRecruiterBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TechnicalRecruiter extends User{

    private String company;

    @OneToMany
    private List<Validation> validations;

}
