package com.project.bot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.project.model.Topic;
import com.project.model.User;
import com.project.repository.TopicRepository;
import com.project.repository.UserRepository;

@Component
public class TelegramBot extends TelegramLongPollingBot {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TopicRepository topicRepository;
	public TelegramBot() {

		super("6257617301:AAGpdrB0zpRY2Bq5o1t3TjHd0bHbJUJuJgc");
	}

	@Override
	public void onUpdateReceived(Update update) {
		String text = update.getMessage().getText();
		System.out.println(text);

	}

	public void sendWelcomeMessage(Long chatId,String name) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText("Welcome to my NotifyMe "+ name +" Happy Learning");
		sendMessage.setChatId(chatId);
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	public void sendSubscriptionMessage(Long userId,Long topicId) {
		
		Long chatId = null;
		String topicName=null;
		SendMessage sendMessage = new SendMessage();
		Optional<Topic> findById2 = topicRepository.findById(topicId);
		Optional<User> findById = userRepository.findById(userId);
		if(findById.isPresent()) {
			User user = findById.get();
			Topic topic = findById2.get();
			topicName=topic.getTopicName();
			chatId = user.getChatId();
		}
		sendMessage.setText("You have subscribed to topic " +topicName);
		sendMessage.setChatId(chatId);
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return "booottheBot";
	}

}
