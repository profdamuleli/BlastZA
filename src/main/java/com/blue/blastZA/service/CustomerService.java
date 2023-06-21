package com.blue.blastZA.service;

import com.blue.blastZA.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public Customer getCustomerById(int id);

    public void deleteById(int id);

    public void createCustomer(Customer customer);

    public void createListCustomer(List<Customer> customer);

    public Customer updateCustomer(Customer customer);
}
