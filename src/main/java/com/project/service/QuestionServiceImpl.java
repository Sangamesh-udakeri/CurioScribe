package com.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mapping.Problem;

@Service
public class QuestionServiceImpl implements QuestionService {
	private final RestTemplate restTemplate = new RestTemplate();
	private final ObjectMapper objectMapper = new ObjectMapper();

	public Problem getQuestion(Long id) throws Exception {
		String url = "http://localhost:8080/user/problem/{id}";
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriVariables);
		String jsonResponse = response.getBody();
		return objectMapper.readValue(jsonResponse, Problem.class);
	}
}
