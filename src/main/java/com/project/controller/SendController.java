package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bot.TelegramBot;
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
			telegramBot.sendQuestionToUser(user.getId(), questionService.getQuestion((long) id));
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
}
