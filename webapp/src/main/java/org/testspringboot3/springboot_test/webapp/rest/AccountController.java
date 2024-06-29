package org.testspringboot3.springboot_test.webapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.testspringboot3.springboot_test.api.AccountsApi;
import org.testspringboot3.springboot_test.model.Account;
import org.testspringboot3.springboot_test.model.DepositRequest;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AccountController implements AccountsApi {

    private final AtomicLong counter = new AtomicLong(10);

    @Override
    public ResponseEntity<Void> depositToAccount(DepositRequest depositRequest) {
        counter.addAndGet(depositRequest.getDepositAmount().longValueExact());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Account> getAccount() {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(counter.get()));
        return ResponseEntity.ok(account);
    }
}
