package com.project.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.project.bot.TelegramBot;
import com.project.dto.RegisterRequest;
import com.project.dto.SubscribeUserToTopicRequest;
import com.project.dto.SubscriptionRequest;
import com.project.model.Topic;
import com.project.model.User;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
@RestController
@RequestMapping("/api/users")
public class UserController {

   
    @Autowired
    private UserService userService;
    @Autowired 
    TelegramBot telegramBot;
    
    @PostMapping("/register")
    public ResponseEntity< String> registerUser(@RequestBody RegisterRequest registerRequest) {
        String registerUser = userService.registerUser(registerRequest);
        telegramBot.sendWelcomeMessage(registerRequest.getChatId(),registerRequest.getUsername());
        return new ResponseEntity<String>(registerUser,HttpStatus.OK);
        
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<String> subscribeUserToTopic(@RequestBody SubscriptionRequest request) {
        String subscribeUserToTopic = userService.subscribeUserToTopic(request);
        telegramBot.sendSubscriptionMessage(request.getUserId(), request.getTopicId());
        return new ResponseEntity<String>(subscribeUserToTopic,HttpStatus.OK);
    }

    @GetMapping("/{userId}/subscriptions")
    public ResponseEntity<Set<Topic>> getAllSubscribedTopics(@PathVariable Long userId) {
         Set<Topic> allSubscribedTopics = userService.getAllSubscribedTopics(userId);
         return new ResponseEntity<Set<Topic>>(allSubscribedTopics,HttpStatus.OK);
    }
    @GetMapping("/getalltopics")
    public ResponseEntity<List<Topic>> getAllTopics(){
    	List<Topic> allTopics = userService.getAllTopics();
    	 return new ResponseEntity<List<Topic>>(allTopics,HttpStatus.OK);
    }
    

}