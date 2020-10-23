package com.kodilla.microservices.transfersgateway.connector;

import com.kodilla.microservices.transfersgateway.request.TransactionPermissionRequest;
import com.kodilla.microservices.transfersgateway.response.TransactionPermissionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {

    @GetMapping("/v1/accounts/request-permission")
    TransactionPermissionResponse getTransactionPermission(@SpringQueryMap TransactionPermissionRequest request);
}

@Slf4j
@Component
class AccountsConnectorFallback implements AccountsConnector {
    @Override
    public TransactionPermissionResponse getTransactionPermission(TransactionPermissionRequest request) {
        log.warn("Fallback: can not get transaction permission");
        return new TransactionPermissionResponse(false);
    }
}
