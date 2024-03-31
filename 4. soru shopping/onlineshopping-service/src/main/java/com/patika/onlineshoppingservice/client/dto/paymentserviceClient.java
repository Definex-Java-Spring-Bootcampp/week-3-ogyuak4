package com.patika.onlineshoppingservice.client.dto;
import com.patika.onlineshoppingservice.client.dto.request.paymentserviceRequest;
import com.patika.onlineshoppingservice.client.dto.response.paymentserviceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service", url = "localhost:8088")
public interface paymentserviceClient {

    @PostMapping("api/akbank/v1/applications")
    paymentserviceResponse createApplication(@RequestBody paymentserviceRequest request);
}
