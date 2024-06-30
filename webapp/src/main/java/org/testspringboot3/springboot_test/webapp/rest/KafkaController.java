package org.testspringboot3.springboot_test.webapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testspringboot3.springboot_test.webapp.service.MessageProducer;

@RestController
public class KafkaController {

    private final MessageProducer messageProducer;

    public KafkaController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        if(message==null || message.isEmpty()) {
            return "Invalid message";
        }
        messageProducer.sendMessage("my-topic", message);
        return "Message sent: " + message;
    }

}
