package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.HRRecruiter;
import com.wind.windrecruitmentapi.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Page<Topic> findTopicsByTopicAuthor(Pageable pageable, HRRecruiter recruiter);

}
