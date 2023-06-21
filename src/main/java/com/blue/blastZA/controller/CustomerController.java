package com.blue.blastZA.controller;

import com.blue.blastZA.exception.CustomerServiceException;
import com.blue.blastZA.model.Customer;
import com.blue.blastZA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomerDetails() {
        return customerService.getCustomers();
    }

    @PostMapping(value = "/customer",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            throw new CustomerServiceException("No data to return from the database");
        }
        customerService.createCustomer(customer);
    }

    @PostMapping(value = "/customers",
            consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public void createListCustomer(@RequestBody List<Customer> customer) {
        if (customer == null) {
            throw new CustomerServiceException("No data to return from the database");
        }
        customerService.createListCustomer(customer);
    }

    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerDetailsById(@PathVariable(value = "customerId") int id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null)
            throw new CustomerServiceException("Customer with id : " + id + " was found");
        return customer;
    }

    @DeleteMapping(value = "/delete/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomerDetailsById(@PathVariable(value = "customerId") int id) {
        customerService.deleteById(id);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }
}
