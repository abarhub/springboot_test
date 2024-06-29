package org.testspringboot3.springboot_test.webapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.testspringboot3.springboot_test.api.AccountsApi;
import org.testspringboot3.springboot_test.model.Account;
import org.testspringboot3.springboot_test.model.DepositRequest;
import org.testspringboot3.springboot_test.webapp.service.AccountService;

import java.math.BigDecimal;

@RestController
public class AccountController implements AccountsApi {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<Void> depositToAccount(DepositRequest depositRequest) {

        accountService.add(depositRequest.getDepositAmount().longValueExact());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Account> getAccount() {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(accountService.get()));
        return ResponseEntity.ok(account);
    }
}
