package com.kodilla.microservices.transfersgateway.service;

import com.kodilla.microservices.commons.Transfer;
import com.kodilla.microservices.commons.TransferMessage;
import com.kodilla.microservices.transfersgateway.exception.TransactionDeniedException;
import com.kodilla.microservices.transfersgateway.request.TransactionPermissionRequest;
import com.kodilla.microservices.transfersgateway.response.TransactionPermissionResponse;
import com.kodilla.microservices.transfersgateway.service.provider.GatewayAccountsProvider;
import com.kodilla.microservices.transfersgateway.service.provider.SimpleAccountsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferProducer {

    private static final String TRANSFERS_TOPIC = "transfers";
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final GatewayAccountsProvider accountsProvider;

    public void sendTransfer(final Transfer transfer) {
        verifyTransactionPermission(transfer);

        TransferMessage transferMessage = new TransferMessage(transfer);
        log.info("Sending message to Kafka, transferMessage: {}", transferMessage);
        kafkaTemplate.send(TRANSFERS_TOPIC, transferMessage);
        log.info("Message was sent");
    }

    private void verifyTransactionPermission(Transfer transfer) {
        TransactionPermissionRequest request =  new TransactionPermissionRequest(transfer.getSenderAccount(), transfer.getAmount());
        TransactionPermissionResponse permission = accountsProvider.getTransactionPermission(request);

        if(!permission.getRequestAccepted()) {
            log.error("Accounts server denied request");
            throw new TransactionDeniedException();
        }
    }

}
