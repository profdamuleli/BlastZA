package com.blue.blastZA.controller;

import com.blue.blastZA.model.Customer;
import com.blue.blastZA.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getCustomerDetails(){
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerDetailsById(@PathVariable(value = "customerId") int id){
        Customer customer = customerService.getCustomerById(id);
        System.out.println(customer);
        return  customer;
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer){
        if(customer != null){
            customerService.createCustomerDetails(customer);
        }
    }

    @DeleteMapping("/delete/customer/{customerId}")
    public void deleteCustomerDetailsById(@PathVariable(value = "customerId") int Id){
        customerService.deleteById(Id);
    }
}
