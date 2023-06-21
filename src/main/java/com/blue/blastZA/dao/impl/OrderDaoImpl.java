package com.blue.blastZA.dao.impl;

import com.blue.blastZA.dao.OrderDao;
import com.blue.blastZA.model.Order;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(order);
    }

    @Override
    public Order get(int Id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Order.class, Id);
    }
}