package com.patika.onlineshoppingservice.producer;

import com.patika.onlineshoppingservice.*;
import com.patika.onlineshoppingservice.configuration.RabbitMQConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class invoiceProducer {
    private final RabbitMQConfiguration rabbitMQConfiguration;
    private final AmqpTemplate amqpTemplate;

    public void sendNotification(com.patika.onlineshoppingservice.producer.invoiceDTO invoiceDTO) {
        log.info("notification sent: {}", invoiceDTO);
        amqpTemplate.convertSendAndReceive(rabbitMQConfiguration.getExchange(), rabbitMQConfiguration.getRoutingkey(), invoiceDTO);
    }

}
