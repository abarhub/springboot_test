package org.testspringboot3.springboot_test.webapp.service;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Service
public class MessageManualConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManualConsumer.class);

    @PostConstruct
    public void init() {
        Thread thread = new Thread(() -> {
            try {
                consume();
            }catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
//        thread.start();
    }

    public void consume() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:29092");
        props.put("group.id", "test-group-manual");
        props.put("enable.auto.commit", "false");
        props.put("auto.offset.reset", "earliest");  // Important pour toujours commencer au début
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "my-client-id3");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic"));

        LOGGER.info("Subscribed to topic: my-topic");

        while (true) {  // Boucle infinie
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                LOGGER.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());

                // Traitez le message ici

                // Ne commitez pas l'offset
                // consumer.commitSync();

                // Optionnel : ajoutez un délai pour éviter une boucle trop rapide
                try {
                    Thread.sleep(1000);  // Pause d'une seconde
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                    throw e;
                }
            }
        }

//        LOGGER.info("Subscribed to topic: my-topic END");
    }

}
