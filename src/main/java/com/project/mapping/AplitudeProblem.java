package com.project.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AplitudeProblem {

	@JsonProperty("questionId")
	private Long id;
	@JsonProperty("questionType")
	private String questionType;
	@JsonProperty("questionBody")
	private String questionBody;
	@Override
	public String toString() {
		return "Type=" + questionType + "\n"
				+" Question=" + questionBody ;
	}
}
