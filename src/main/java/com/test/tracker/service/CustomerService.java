package com.test.tracker.service;

import com.test.tracker.domain.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    void updateCustomer (Customer customer);
    List<Customer> getAllCustomers();
}
