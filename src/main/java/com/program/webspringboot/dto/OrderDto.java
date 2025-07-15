package com.program.webspringboot.dto;

import com.program.webspringboot.entities.Order;
import com.program.webspringboot.entities.OrderItem;
import com.program.webspringboot.entities.Payment;
import com.program.webspringboot.entities.User;
import com.program.webspringboot.entities.enums.OrderStatus;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant moment;
    private Integer orderStatus;
    private User client;
    private Set<OrderItem> orderItems = new HashSet<>();
    private Payment payment;

    public OrderDto() {}

    public OrderDto(Order order) {
        BeanUtils.copyProperties(order, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        Double totalPrice = 0.0;

        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getSubTotal();
        }

        return totalPrice;
    }
}
