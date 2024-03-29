package com.patika.kredinbizdeservice.client;

import com.patika.kredinbizdeservice.client.dto.request.AkbankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.request.GarantibankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(value = "garantibank-service", url = "localhost:8089")
public interface GarantibankServiceClient {

    @PostMapping("api/garantibank/v1/applications")
    ApplicationResponse createApplication(@RequestBody GarantibankApplicationRequest request);
}
