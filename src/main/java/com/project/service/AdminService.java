package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.model.Topic;
import com.project.model.User;

public interface AdminService {

	 public List<User> getAllUsers();
	 public String deleteUser(Long userId);
	 public List<Topic> getAllTopics();
	 public Topic createTopic( Topic topic); 
	 public String deleteTopic(@PathVariable Long topicId);
}
