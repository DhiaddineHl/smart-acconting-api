package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private String duration;

    @ElementCollection
    private List<String> requirements;

    @ManyToOne
    private HRRecruiter topicAuthor;

}
