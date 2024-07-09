package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnterpriseManager extends User{

    private String company;

}
