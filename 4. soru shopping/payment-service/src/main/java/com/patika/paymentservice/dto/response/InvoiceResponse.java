package com.patika.paymentservice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class InvoiceResponse {
    private Long id;
    private double totalPrice;
    private LocalDateTime date;
    private List<Long> productIds;
}

