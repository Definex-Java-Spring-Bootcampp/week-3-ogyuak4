package com.patika.onlineshoppingservice.model;

import lombok.*;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long id;
    private Customer customerInfo;
    private List<Product> product;
    private Invoice invoice;
}
