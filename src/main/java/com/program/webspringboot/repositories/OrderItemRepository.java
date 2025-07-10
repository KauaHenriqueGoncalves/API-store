package com.program.webspringboot.repositories;

import com.program.webspringboot.entities.OrderItem;
import com.program.webspringboot.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
