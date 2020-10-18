package com.kodilla.microservices.transfersgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableDiscoveryClient
@SpringBootApplication
public class TransfersGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransfersGatewayApplication.class, args);
    }

}
