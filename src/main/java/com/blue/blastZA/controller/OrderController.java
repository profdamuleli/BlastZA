package com.blue.blastZA.controller;

import com.blue.blastZA.model.Order;
import com.blue.blastZA.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{customerId}")
    public Order getCustomerOrderById(@PathVariable int customerId) {
        return orderService.getCustomerOrderById(customerId);
    }

    @PostMapping("/order")
    public void saveCustomerOder(@RequestBody Order order) {
        orderService.createCustomerOrder(order);
    }
}
