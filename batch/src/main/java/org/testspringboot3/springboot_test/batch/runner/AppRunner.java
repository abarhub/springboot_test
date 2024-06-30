package org.testspringboot3.springboot_test.batch.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.testspringboot3.springboot_test.batch.service.ClientService;

@Service
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER= LoggerFactory.getLogger(AppRunner.class);

    private final ClientService clientService;

    public AppRunner(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("AppRunner started");
        clientService.appel();
    }
}
