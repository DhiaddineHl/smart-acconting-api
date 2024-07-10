package com.wind.windrecruitmentapi.utils.topics;

import java.util.List;

public record TopicResponse(
    String name,
    String description,
    String duration,
    List<String> requirements
) {
}
