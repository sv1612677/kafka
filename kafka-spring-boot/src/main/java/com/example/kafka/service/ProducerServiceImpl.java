package com.example.kafka.service;

import com.example.kafka.config.KafkaProducerConfig;
import com.example.kafka.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerServiceImpl  implements ProducerService{

    @Autowired
    KafkaTemplate<String,Message> kafkaTemplate;

    @Override
    public void sendMessage(Message message) {
        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(KafkaProducerConfig.getTopicName(), message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onSuccess(SendResult<String, Message> stringMessageSendResult) {
                System.out.println("Sent message=[" + message  +
                        "] with offset=[" + stringMessageSendResult.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + throwable.getMessage());
            }


        });
    }
}
