package com.blue.blastZA.dao;

import com.blue.blastZA.model.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getAll();

    public Customer get(int id);

    public void save(Customer customer);

    public void saveList(List<Customer> customer);

    public void delete(int id);
}
