package com.blue.blastZA.dao;

import com.blue.blastZA.model.Order;

public interface OrderDao {
    public void save(Order order);

    public Order get(int Id);
}
