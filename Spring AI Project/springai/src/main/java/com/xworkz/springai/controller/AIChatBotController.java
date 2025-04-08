package com.xworkz.springai.controller;

import com.xworkz.springai.service.AIChatBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class AIChatBotController {

    @Autowired
   private AIChatBot aiChatBot;

    @GetMapping
    public ResponseEntity<String> onSend(@RequestParam String prompt){
        System.out.println(prompt);
    String res=aiChatBot.getResponse(prompt);
        System.out.println(res);
        System.out.println("hi");
return ResponseEntity.ok(res) ;

    }
}
