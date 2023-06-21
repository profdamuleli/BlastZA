package com.blue.blastZA.dao.impl;

import com.blue.blastZA.dao.CustomerDao;
import com.blue.blastZA.exception.CustomerServiceException;
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
    public List<Customer> getAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, id);
        if (customer == null) {
            throw new CustomerServiceException("Customer with id : " + id + " was found");
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        if (customer == null) {
            throw new CustomerServiceException("No customer to save");
        }
        currentSession.persist(customer);
    }

    @Override
    public void saveList(List<Customer> customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        if (customer == null) {
            throw new CustomerServiceException("No customer to save");
        }
        customer.listIterator();
        for (Customer obj : customer) {
            currentSession.persist(obj);
        }
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, id);
        if (customer == null) {
            throw new CustomerServiceException("Customer with id : " + id + " was found");
        } else {
            currentSession.delete(customer);
        }
    }

}
