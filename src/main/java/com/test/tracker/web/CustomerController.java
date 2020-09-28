package com.test.tracker.web;

import com.test.tracker.domain.Customer;
import com.test.tracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @GetMapping(value = "/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
