package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bot.TelegramBot;
import com.project.exception.TelegramApiException;
import com.project.mapping.Problem;
import com.project.service.QuestionService;

@RestController
@RequestMapping
public class QuesstionController {


    private final QuestionService questionService;
    private final TelegramBot telegramBot;

    @Autowired
    public QuesstionController(QuestionService questionService, TelegramBot telegramBot) {
        this.questionService = questionService;
        this.telegramBot = telegramBot;
    }

    @GetMapping("/question/{id}")
    public Problem getQuestion(@PathVariable Long id) throws TelegramApiException {
        Problem question = null;
        try {
            question = questionService.getQuestion(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return question;
    }
}
