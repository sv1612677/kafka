package com.example.kafka.service;

import com.example.kafka.entity.Message;

public interface ProducerService {
    void sendMessage(Message message);
}
