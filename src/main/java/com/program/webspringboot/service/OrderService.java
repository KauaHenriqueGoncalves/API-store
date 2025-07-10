package com.program.webspringboot.service;

import com.program.webspringboot.entities.Order;
import com.program.webspringboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }

    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

}
