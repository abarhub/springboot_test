package org.testspringboot3.springboot_test.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.testspringboot3.springboot_test.core.DateUtils;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService {

    private static final Logger LOGGER= LoggerFactory.getLogger(AccountService.class);

    private final AtomicLong counter = new AtomicLong(10);

    public void add(long amount) {
        LOGGER.info("Adding {} to account at {}", amount, DateUtils.getDate());
        counter.addAndGet(amount);
    }

    public long get() {
        return counter.get();
    }

}
