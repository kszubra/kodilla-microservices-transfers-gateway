package com.kodilla.microservices.transfersgateway.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionPermissionRequest {

    private String fromAccountNumber;

    private BigDecimal value;
}
