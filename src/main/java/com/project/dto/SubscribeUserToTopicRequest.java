package com.project.dto;

import com.project.model.Topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscribeUserToTopicRequest {
	private Long userId;
	private String topic;

}
