package com.patika.onlineshoppingservice.client.dto.response;

import java.time.LocalDateTime;
import java.util.List;



import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class paymentserviceResponse {
    private String customerName;
    private String customerSurname;
    private String address;
    private double totalPrice;
    private LocalDateTime date;
    private List<Long> productIds;
}
