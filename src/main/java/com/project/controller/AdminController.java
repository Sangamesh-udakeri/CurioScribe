package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Topic;
import com.project.model.User;
import com.project.service.AdminService;
import com.project.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		 List<User> allUsers = adminService.getAllUsers();
		 return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
    @DeleteMapping("/deleteusers/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    	String deleteUser = adminService.deleteUser(userId);
    	 return new ResponseEntity<String>(deleteUser,HttpStatus.OK);
    }
    @GetMapping("/getalltopics")
    public ResponseEntity<List<Topic>> getAllTopics() {
         List<Topic> allTopics = adminService.getAllTopics();
         return new ResponseEntity<List<Topic>>(allTopics,HttpStatus.OK);
    }

    @PostMapping("/creattopic")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
         Topic createTopic = adminService.createTopic(topic);
         return new ResponseEntity<Topic>(createTopic,HttpStatus.OK);
    }

    @DeleteMapping("/deletetopics/{topicId}")
    public ResponseEntity<String>  deleteTopic(@PathVariable Long topicId) {
    	String deleteTopic = adminService.deleteTopic(topicId);
    	  return new ResponseEntity<String>(deleteTopic,HttpStatus.OK);
    }
}
