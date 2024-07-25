package com.wind.windrecruitmentapi.utils.topics;

import java.util.List;

public record TopicResponse(

    Integer id,
    String name,
    String description,
    Float duration,
    List<String> requirements
) {
}
