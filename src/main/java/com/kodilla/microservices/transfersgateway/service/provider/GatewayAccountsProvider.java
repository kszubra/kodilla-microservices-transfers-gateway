package com.kodilla.microservices.transfersgateway.service.provider;

import com.kodilla.microservices.transfersgateway.request.TransactionPermissionRequest;
import com.kodilla.microservices.transfersgateway.response.TransactionPermissionResponse;

public interface GatewayAccountsProvider {
    TransactionPermissionResponse getTransactionPermission(TransactionPermissionRequest request);
}
