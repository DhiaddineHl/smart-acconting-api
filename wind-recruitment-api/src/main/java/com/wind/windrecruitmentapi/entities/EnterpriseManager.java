package com.wind.windrecruitmentapi.entities;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder(builderMethodName = "managerBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EnterpriseManager extends User{

    private String company;

}
