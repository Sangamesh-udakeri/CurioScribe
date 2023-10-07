package com.project.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	private String username;
	private String email;
	private String password;
	private Long chatId;
}