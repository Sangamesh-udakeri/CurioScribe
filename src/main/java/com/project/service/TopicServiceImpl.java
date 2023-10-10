package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Topic;
import com.project.model.User;
import com.project.repository.TopicRepository;
import com.project.repository.UserRepository;
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TopicRepository topicRepository;
	@Override
	public String unsubscribeUserFromTopic(Long userId, Long topicId) {
		 User user = userRepository.findById(userId).orElseThrow();
		 Topic topic = topicRepository.findById(topicId).orElseThrow();
		 user.getSubscribedTopics().remove(topic);
	     userRepository.save(user);
		return "unsubscribed";
	}

}
