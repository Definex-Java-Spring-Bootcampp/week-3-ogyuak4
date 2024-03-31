package com.patika.onlineshoppingservice.producer;



import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class invoiceDTO {
    private Long id;
    private String customerName;
    private String customerSurname;
    private String address;
    private double totalPrice;
    private LocalDateTime date;
}
