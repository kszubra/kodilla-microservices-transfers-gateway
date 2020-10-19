package com.kodilla.microservices.transfersgateway.service.provider;

import com.kodilla.microservices.transfersgateway.connector.AccountsConnector;
import com.kodilla.microservices.transfersgateway.request.TransactionPermissionRequest;
import com.kodilla.microservices.transfersgateway.response.TransactionPermissionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimpleAccountsProvider implements GatewayAccountsProvider {

    private final AccountsConnector connector;

    @Override
    public TransactionPermissionResponse getTransactionPermission(TransactionPermissionRequest request) {
        return connector.getTransactionPermission(request);
    }
}
