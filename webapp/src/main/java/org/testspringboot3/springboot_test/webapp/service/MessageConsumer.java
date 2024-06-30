package org.testspringboot3.springboot_test.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(String message) {
        LOGGER.info("Received message: {}", message);
    }


}
