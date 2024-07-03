package org.testspringboot3.springboot_test.webapp.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

//    @KafkaListener(topics = "my-topic", groupId = "my-group-id",
//            containerFactory = "kafkaListenerContainerFactory")
//    public void listen(String message) {
//        LOGGER.info("Received message : {}", message);
//    }


//    @KafkaListener(topics = "my-topic", groupId = "my-group-id2",
//            containerFactory = "kafkaListenerContainerFactory2")
//    public void listen2(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
//        String message=record.value();
//        boolean commit=false;
//        LOGGER.info("Received message2: {} (partition:{},offset:{},key:{},commit:{},thread:{})",
//                message,record.partition(),record.offset(),
//                record.key(), commit,Thread.currentThread().getName());
//        if(commit) {
//            LOGGER.info("ack");
//            acknowledgment.acknowledge();
//        } else {
//            //acknowledgment.nack(Duration.ZERO);
////            LOGGER.info("pas de commit");
//        }
//    }


}
