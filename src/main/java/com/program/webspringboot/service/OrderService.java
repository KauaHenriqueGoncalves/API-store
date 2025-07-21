package com.program.webspringboot.service;

import com.program.webspringboot.dto.OrderDto;
import com.program.webspringboot.entities.Order;
import com.program.webspringboot.repositories.OrderRepository;
import com.program.webspringboot.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        orders.forEach(order -> orderDtos.add(new OrderDto(order)));
        return orderDtos;
    }

    public OrderDto findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return new OrderDto(order.get());
        }
        throw new ResourceNotFoundException("Order not found");
    }

    public OrderDto insert(OrderDto orderDto) {
        Order order = new Order();
        order.setMoment(orderDto.getMoment());
        order.setOrderStatus(orderDto.getOrderStatus());
        order = orderRepository.save(order);
        return new OrderDto(order);
    }

    public OrderDto update(Long id, OrderDto orderDto) {
        Order order = orderRepository.getReferenceById(id);
        order.setMoment(orderDto.getMoment());
        order.setOrderStatus(orderDto.getOrderStatus());
        order = orderRepository.save(order);
        return new OrderDto(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

}
