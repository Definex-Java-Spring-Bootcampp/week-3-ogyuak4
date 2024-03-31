package com.patika.onlineshoppingservice;

import com.patika.onlineshoppingservice.model.Customer;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableRabbit
public class OnlineshoppingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineshoppingServiceApplication.class, args);

    }

}
