package com.blue.blastZA.service.impl;

import com.blue.blastZA.dao.OrderDao;
import com.blue.blastZA.model.Order;
import com.blue.blastZA.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public void createCustomerOrder(Order order) {


        orderDao.save(order);
    }

    @Transactional
    @Override
    public Order getCustomerOrderById(int Id) {
        return orderDao.get(Id);
    }
}
