package com.patika.onlineshoppingservice.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Invoice {
    private Long id;
    private String customerName;
    private String customerSurname;
    private String address;
    private double totalPrice;
    private LocalDateTime date;
    private List<Product> products;

}
