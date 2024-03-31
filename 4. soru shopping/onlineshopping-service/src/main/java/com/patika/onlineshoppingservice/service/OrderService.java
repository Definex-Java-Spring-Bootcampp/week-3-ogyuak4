package com.patika.onlineshoppingservice.service;

import com.patika.onlineshoppingservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private long nextId = 1;

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public Order addOrder(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    public Order updateOrder(long id, Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getId() == id) {
                updatedOrder.setId(id);
                orders.set(i, updatedOrder);
                return updatedOrder;
            }
        }
        return null;
    }

    public void deleteOrder(long id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
