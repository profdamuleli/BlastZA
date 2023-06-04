package com.blue.blastZA.dao;

import com.blue.blastZA.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerDao {
    public List<Customer> get();

    public Customer getCustomerById(int id);

    public void create(Customer customer);

    public void delete(int id);
}
