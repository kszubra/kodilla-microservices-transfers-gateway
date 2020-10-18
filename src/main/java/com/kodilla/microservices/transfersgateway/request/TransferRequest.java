package com.kodilla.microservices.transfersgateway.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TransferRequest {
    private String senderAccount;
    private String recipientAccount;
    private String title;
    private BigDecimal amount;
}
