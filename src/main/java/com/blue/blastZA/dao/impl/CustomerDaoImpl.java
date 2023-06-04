package com.blue.blastZA.dao.impl;

import com.blue.blastZA.dao.CustomerDao;
import com.blue.blastZA.model.Customer;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    //TODO : write it well
    @Override
    public Customer getCustomerById(int id){
        Customer customer = this.get().get(id - 1);
        return customer;
    }

    @Override
    public void create(Customer customer){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(customer);
    }

    @Override
    public void delete(int id){
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = this.get().get(id - 1);

        currentSession.delete(customer);
    }

}
