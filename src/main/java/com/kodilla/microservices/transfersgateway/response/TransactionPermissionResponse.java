package com.kodilla.microservices.transfersgateway.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionPermissionResponse {
    private Boolean requestAccepted;
}
