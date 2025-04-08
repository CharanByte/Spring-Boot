package com.xworkz.springai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AIChatBotImp implements AIChatBot{

    ChatClient chatClient;

    AIChatBotImp(OllamaChatModel ollamaChatModel){
        this.chatClient=ChatClient.create(ollamaChatModel);
    }
    @Override
    public String getResponse(String prompt) {
        String res=chatClient.prompt(prompt).call().content();
        return res;
    }
}
