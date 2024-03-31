package com.patika.onlineshoppingservice.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
}
