package com.blue.blastZA.dao;

import com.blue.blastZA.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getAll();

    public Customer get(int id);

    public void save(Customer customer);

    public void delete(int id);
}
