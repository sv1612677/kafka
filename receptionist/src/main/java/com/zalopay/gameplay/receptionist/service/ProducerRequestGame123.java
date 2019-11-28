package com.zalopay.gameplay.receptionist.service;

import com.zalopay.gameplay.receptionist.constant.TopicType;
import com.zalopay.gameplay.receptionist.model.RequestGame123;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerRequestGame123 {

    @Autowired
    KafkaTemplate<String, RequestGame123> kafkaTemplate;

    public void sendRequestGame123(RequestGame123 requestGame123, String topic){
        Message<RequestGame123> message = MessageBuilder
                .withPayload(requestGame123)
                .setHeader(KafkaHeaders.TOPIC,topic)
                .build();
        kafkaTemplate.send(message);
    }
}
