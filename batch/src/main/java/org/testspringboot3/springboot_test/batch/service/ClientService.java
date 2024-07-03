package org.testspringboot3.springboot_test.batch.service;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.testspringboot3.springboot_test.api.AccountsApi;
import org.testspringboot3.springboot_test.invoker.ApiClient;
import org.testspringboot3.springboot_test.model.DepositRequest;

@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    public void appel() {
        LOGGER.info("appel");

        RestClient restClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl("http://localhost:8080")
                .build();
        ApiClient apiClient = new ApiClient(restClient);
        apiClient.setBasePath("http://localhost:8080");
        AccountsApi accountsApi = new AccountsApi(apiClient);
        var res = accountsApi.getAccount();
        LOGGER.info("res: {}", res);
        var montant = res.getBalance().longValueExact();

        DepositRequest depositRequest = new DepositRequest();
        depositRequest.depositAmount(BigDecimal.valueOf(20));
        accountsApi.depositToAccount(depositRequest);

        var res2 = accountsApi.getAccount();
        LOGGER.info("res2: {} ({})", res2, (res2.getBalance().longValueExact() == montant + 20L) ? "OK" : "KO");
    }
}
