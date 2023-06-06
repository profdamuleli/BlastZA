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
        List<Customer> customerList = customerDao.getAll();
        return customerList;
    }

    @Transactional
    @Override
    public Customer getCustomerById(int id){
        Customer customer = customerDao.get(id);
        return customer;
    }

    @Transactional
    @Override
    public void deleteById(int id){
        customerDao.delete(id);
    }

    @Transactional
    @Override
    public void createCustomer(Customer customer){
        customerDao.save(customer);
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer customer){
        if(customer.getCustomer_id() != 0){
            customerDao.save(customer);
        }
        return customer;
    }
}
