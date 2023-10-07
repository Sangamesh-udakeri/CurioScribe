package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dto.RegisterRequest;
import com.project.dto.SubscriptionRequest;
import com.project.exception.UserNotFound;
import com.project.exception.UserRegistrationException;
import com.project.model.Topic;
import com.project.model.User;
import com.project.repository.TopicRepository;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TopicRepository topicRepository;

	@Override
	public String registerUser(RegisterRequest registerRequest) {
		if (userRepository.existsByEmail(registerRequest.getEmail())
				&& userRepository.existsByUserName(registerRequest.getUsername())) {
			throw new UserRegistrationException("already registed with this email!");
		}
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setUserName(registerRequest.getUsername());
		user.setPassword(registerRequest.getPassword());
		user.setChatId(registerRequest.getChatId());
		userRepository.save(user);
		return "registered";
	}

	@Override
	public String subscribeUserToTopic(SubscriptionRequest subscriptionRequest) {
		User user = userRepository.findById(subscriptionRequest.getUserId()).orElseThrow();
		Topic topic = topicRepository.findById(subscriptionRequest.getTopicId()).orElseThrow();
		user.getSubscribedTopics().add(topic);
		userRepository.save(user);
		return "Subscribed";
	}
	
	@Override
	public Set<Topic> getAllSubscribedTopics(Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			throw new UserNotFound("Not registed with this id");
		}
		return findById.get().getSubscribedTopics();
	}
	
	@Override
	public List<Topic> getAllTopics() {
		List<Topic> findAll = topicRepository.findAll();
		return findAll;
	}
}
