package com.kodilla.microservices.transfersgateway.service;

import com.kodilla.microservices.commons.AccountsUpdate;
import com.kodilla.microservices.commons.AccountsUpdateMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountUpdateProducer {

    private static final String ACCOUNTS_UPDATE_TOPIC = "accounts-update";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUpdate(AccountsUpdate update) {
        AccountsUpdateMessage message = new AccountsUpdateMessage(update);
        log.info("Sending account update message to Kafka, updateMessage: {}", update.getValue());
        kafkaTemplate.send(ACCOUNTS_UPDATE_TOPIC, message);
        log.info("Message was sent");
    }
}
