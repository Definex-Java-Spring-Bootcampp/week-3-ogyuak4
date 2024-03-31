package com.patika.onlineshoppingservice.model;

import java.time.LocalDate;
import java.util.List;

import com.patika.onlineshoppingservice.model.*;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String address;
    private String email;
    private String phoneNo;
    private List<Order> orderList;
    public void addOrder(Order order) {
        orderList.add(order);
    }
}

