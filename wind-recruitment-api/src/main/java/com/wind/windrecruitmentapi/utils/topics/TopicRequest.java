package com.wind.windrecruitmentapi.utils.topics;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TopicRequest {

    private String name;
    private String description;
    private String duration;
    private List<String> requirements;

}
