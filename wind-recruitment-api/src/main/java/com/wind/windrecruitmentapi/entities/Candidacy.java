package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Candidacy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Topic topic;

    private String createdAt;

}
