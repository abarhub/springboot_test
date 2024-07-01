package org.testspringboot3.springboot_test.webapp.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.testspringboot3.springboot_test.webapp.service.MessageProducer;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class KafkaController {

    private final MessageProducer messageProducer;

    private final AtomicLong counter = new AtomicLong(0);

    public KafkaController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        if (message == null || message.isEmpty()) {
            return "Invalid message";
        }
        var id = counter.accumulateAndGet(1, (x, y) -> (x + y) % 3);
        var key="key" + id;
        messageProducer.sendMessage("my-topic", key, message);
        return "Message sent ("+key+"): " + message;
    }

}
