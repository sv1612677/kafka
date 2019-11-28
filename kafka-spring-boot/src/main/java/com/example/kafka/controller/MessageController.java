package com.example.kafka.controller;

import com.example.kafka.entity.Message;
import com.example.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    ProducerService producerService;

    @PostMapping(value = "/messages")
    public String sendMessage(@RequestBody Message message){
        producerService.sendMessage(message);
        return message.getMessage();
    }
}
