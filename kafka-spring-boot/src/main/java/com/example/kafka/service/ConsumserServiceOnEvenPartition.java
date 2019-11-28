package com.example.kafka.service;

import com.example.kafka.entity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumserServiceOnEvenPartition {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "kafka-spring-boot",
            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "0"),
                    @PartitionOffset(partition = "2", initialOffset = "0")
            }),containerFactory = "messageKafkaListenerContainerFactory")
    public void listenToParition(@Payload Message message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Messasge: " + message.getMessage() + message.getAddress() + "from partition: " + partition);
    }
}
