package com.wind.windrecruitmentapi.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder(builderMethodName = "candidateBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidate extends User{

    private String university;

}
