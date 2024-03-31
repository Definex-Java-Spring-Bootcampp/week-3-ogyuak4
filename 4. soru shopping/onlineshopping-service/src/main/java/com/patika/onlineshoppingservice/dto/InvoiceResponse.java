package com.patika.onlineshoppingservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class InvoiceResponse {
    private Long id;
    private String customerName;
    private String customerSurname;
    private String address;
    private double totalPrice;
    private LocalDateTime date;
    private List<Long> productIds;
}
