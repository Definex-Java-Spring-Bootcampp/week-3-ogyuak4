package com.patika.onlineshoppingservice.service;


import com.patika.onlineshoppingservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private long nextId = 1;

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(nextId++);
        customers.add(customer);
        return customer;
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getId() == id) {
                updatedCustomer.setId(id);
                customers.set(i, updatedCustomer);
                return updatedCustomer;
            }
        }
        return null;
    }

    public void deleteCustomer(long id) {
        customers.removeIf(customer -> customer.getId() == id);
    }
}