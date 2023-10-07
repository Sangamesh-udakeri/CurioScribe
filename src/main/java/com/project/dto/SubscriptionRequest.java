package com.project.dto;

import java.util.List;

import com.project.model.Topic;


import lombok.Data;
@Data
public class SubscriptionRequest {
    private Long userId; 
    private Long topicId;
}