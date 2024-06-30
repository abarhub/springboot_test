package org.testspringboot3.springboot_test.webapp.rest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.testspringboot3.springboot_test.webapp.service.MessageConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;


class KafkaControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaControllerTest.class);

    @Test
    void sendMessage() {

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("http://localhost:8080")
                .build();

        var res=restClient.post()
                //.uri("http://localhost:8080/send?message=abc")
                .uri("/send?message=abc2")
                .contentType(APPLICATION_JSON)
                .retrieve()
                .body(String.class);

        LOGGER.info("res post={}", res);
    }
}