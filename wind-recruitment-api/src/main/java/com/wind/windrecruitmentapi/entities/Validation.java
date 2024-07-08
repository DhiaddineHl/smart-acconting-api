package com.wind.windrecruitmentapi.entities;


import com.wind.windrecruitmentapi.utils.ValidationStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Candidacy candidacy;

    private String createdAt;

    private ValidationStatus status;

    @ManyToOne
    private HRRecruiter hrRecruiter;

    @ManyToOne
    private TechnicalRecruiter technicalRecruiter;

}