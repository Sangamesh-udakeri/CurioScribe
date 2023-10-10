package com.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bot.TelegramBot;
import com.project.mapping.DbmsProblem;
import com.project.model.Topic;
import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.QuestionService;

@RequestMapping("/send")
@RestController
public class SendController {

	@Autowired
	TelegramBot telegramBot;
	@Autowired
	QuestionService questionService;
	@Autowired
	UserRepository userRepository;

	@GetMapping("/sendquestion/{id}")
	public String sendQuestionToUser(@PathVariable Long id) throws Throwable {
		List<User> findAll = userRepository.findAll();

		for (User user : findAll) {
			Set<Topic> subscribedTopics = user.getSubscribedTopics();
			for (Topic s : subscribedTopics) {
				if (s.getTopicName().equalsIgnoreCase("aplitude")) {
					telegramBot.sendAplitudeQuestionToUser(user.getId(), questionService.getAplitudeProblem(id));
				} else if (s.getTopicName().equalsIgnoreCase("CodingPractice")) {
					telegramBot.sendQuestionToUser(user.getId(), questionService.getQuestion(id));
				} else if (s.getTopicName().equalsIgnoreCase("Dbms")) {
					telegramBot.sendDbmsQuestionToUser(user.getId(), questionService.getDbmsProblem(id));
				}
			}
		}
		return "done";

	}

	@GetMapping("/sendAplitudequestion/{id}")
	public String sendAplitudeQuestionToUser(@PathVariable Long id) throws Throwable {
		List<User> findAll = userRepository.findAll();
		for (User user : findAll) {
			telegramBot.sendAplitudeQuestionToUser(user.getId(), questionService.getAplitudeProblem((long) id));
		}
		return "done";

	}

	@GetMapping("/sendDbmsquestion/{id}")
	public String sendDbmsQuestionToUser(@PathVariable Long id) throws Throwable {
		List<User> findAll = userRepository.findAll();
		for (User user : findAll) {
			telegramBot.sendDbmsQuestionToUser(user.getId(), questionService.getDbmsProblem((long) id));
		}
		return "done";

	}
}
