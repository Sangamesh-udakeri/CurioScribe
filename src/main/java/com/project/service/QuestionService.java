package com.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.project.mapping.AplitudeProblem;
import com.project.mapping.Problem;

public interface QuestionService {

	 public Problem getQuestion(Long id) throws Exception;
	 public AplitudeProblem getAplitudeProblem(Long id) throws JsonMappingException, JsonProcessingException;
}
