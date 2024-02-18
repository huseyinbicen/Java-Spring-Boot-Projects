package com.pexax.springbootkafka.service;

import com.pexax.springbootkafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserListener {

    @KafkaListener(topics = "pexax.teamname.kafka-demo-user-creation.0", containerFactory = "kafkaListenerContainerFactory")
    public void consume(
            @Payload User user,
            @Header("X-AgentName") String agentName,
            @Header(KafkaHeaders.OFFSET) int offset,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            Acknowledgment ack
    ) {
        log.info("userId: {}, agentName: {}, partition: {}, offset: {}", user.getId(), agentName, partition, offset);
        log.info("Event Listener user: {}", user);
        ack.acknowledge();
    }

}
