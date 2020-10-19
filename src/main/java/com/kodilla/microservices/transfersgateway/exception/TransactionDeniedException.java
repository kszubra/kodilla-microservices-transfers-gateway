package com.kodilla.microservices.transfersgateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason="Transaction denied by accounts server")
public class TransactionDeniedException extends RuntimeException {

}
