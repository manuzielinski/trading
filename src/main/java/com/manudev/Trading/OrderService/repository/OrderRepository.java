package com.manudev.Trading.OrderService.repository;

import com.manudev.Trading.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserId(Long userId);
}
