package com.blue.blastZA.service;

import com.blue.blastZA.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public Customer getCustomerById(int id);

    public void deleteById(int id);

    public void createCustomerDetails(Customer customer);
}
