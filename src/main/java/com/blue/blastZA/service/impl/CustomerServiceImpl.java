package com.blue.blastZA.service.impl;

import com.blue.blastZA.dao.CustomerDao;
import com.blue.blastZA.model.Customer;
import com.blue.blastZA.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Transactional
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customerList = customerDao.get();
        System.out.println("Debug : " + customerList);
        return customerList;
    }

    @Transactional
    @Override
    public Customer getCustomerById(int id){
        Customer customer = customerDao.getCustomerById(id);
        System.out.println("Debug : " + customer);
        return customer;
    }

    @Transactional
    @Override
    public void deleteById(int id){
        customerDao.delete(id);
    }

    @Transactional
    @Override
    public void createCustomerDetails(Customer customer){
        customerDao.create(customer);
    }

}
