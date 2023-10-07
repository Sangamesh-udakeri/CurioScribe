package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
