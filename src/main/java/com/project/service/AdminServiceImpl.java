package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Topic;
import com.project.model.User;
import com.project.repository.AdminRepository;
import com.project.repository.TopicRepository;
import com.project.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TopicRepository topicRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String deleteUser(Long userId) {
		if (!userRepository.existsById(userId)) {

			return "Could not find user by this id";
		}
		userRepository.deleteById(userId);
		return "Deleted";
	}

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> findAll = topicRepository.findAll();
		return findAll;
	}

	@Override
	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public String deleteTopic(Long topicId) {
		if (!topicRepository.existsById(topicId)) {
			return "Could not find topic by this id";
		}
		topicRepository.deleteById(topicId);
		return "Deleted";
	}

}
