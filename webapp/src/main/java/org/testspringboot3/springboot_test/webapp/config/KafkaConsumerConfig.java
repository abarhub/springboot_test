package org.testspringboot3.springboot_test.webapp.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

@Configuration
public class KafkaConsumerConfig {

    //    @Bean
    //    public ConsumerFactory<String, String> consumerFactory() {
    //        Map<String, Object> configProps = new HashMap<>();
    //        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
    //        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
    //        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
    // StringDeserializer.class);
    //        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
    // StringDeserializer.class);
    ////        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    //        configProps.put(ConsumerConfig.CLIENT_ID_CONFIG, "my-client-id");
    //        return new DefaultKafkaConsumerFactory<>(configProps);
    //    }
    //
    //    @Bean
    //    public ConcurrentKafkaListenerContainerFactory<String, String>
    // kafkaListenerContainerFactory() {
    //        ConcurrentKafkaListenerContainerFactory<String, String> factory = new
    // ConcurrentKafkaListenerContainerFactory<>();
    //        factory.setConsumerFactory(consumerFactory());
    ////
    // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
    //        return factory;
    //    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory2() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id2");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        configProps.put(ConsumerConfig.CLIENT_ID_CONFIG, "my-client-id2");
        return new DefaultKafkaConsumerFactory<>(configProps);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory2());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        //        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }
}
