package com.blue.blastZA.service;

import com.blue.blastZA.model.Order;

public interface OrderService {
    public void createCustomerOrder(Order order);

    public Order getCustomerOrderById(int Id);
}
