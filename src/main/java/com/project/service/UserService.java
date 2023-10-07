package com.project.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.project.dto.RegisterRequest;
import com.project.dto.SubscribeUserToTopicRequest;
import com.project.dto.SubscriptionRequest;
import com.project.model.Topic;
import com.project.model.User;

public interface UserService {

	String registerUser(RegisterRequest registerRequest);

	Set<Topic> getAllSubscribedTopics(Long userId);

	List<Topic> getAllTopics();

	String subscribeUserToTopic(SubscriptionRequest subscriptionRequest);
}
