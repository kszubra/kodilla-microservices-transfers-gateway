package com.kodilla.microservices.transfersgateway.web;

import com.kodilla.microservices.commons.Transfer;
import com.kodilla.microservices.transfersgateway.request.TransferRequest;
import com.kodilla.microservices.transfersgateway.service.TransferProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferProducer transferProducer;

    @PostMapping
    public void saveTransfer(@RequestBody TransferRequest request) {
        log.info("Received transfer request: {}", request);
        Transfer transfer = new Transfer();
        transfer.setTitle(request.getTitle());
        transfer.setAmount(request.getAmount());
        transfer.setSenderAccount(request.getSenderAccount());
        transfer.setRecipientAccount(request.getRecipientAccount());

        transferProducer.sendTransfer(transfer);
    }
}
