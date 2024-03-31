package com.patika.onlineshoppingservice.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "payment-service", url = "localhost:8088")
public interface paymentserviceClient {

}
