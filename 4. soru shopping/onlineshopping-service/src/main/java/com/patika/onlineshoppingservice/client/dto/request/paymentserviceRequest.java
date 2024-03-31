package com.patika.onlineshoppingservice.client.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class paymentserviceRequest {
    private Long id;
    private double totalPrice;
    private LocalDateTime date;
    private List<Long> productIds;
}
