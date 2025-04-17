package com.manudev.Trading.OrderService.service.impl;

import com.manudev.Trading.OrderService.domain.OrderType;
import com.manudev.Trading.OrderService.model.Order;
import com.manudev.Trading.OrderService.model.OrderItem;
import com.manudev.Trading.OrderService.repository.OrderRepository;
import com.manudev.Trading.OrderService.service.OrderService;
import com.manudev.Trading.coinService.model.Coin;
import com.manudev.Trading.userService.mapper.UserMapper;
import com.manudev.Trading.userService.model.UserEntity;
import com.manudev.Trading.walletService.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Order createOrder(UserEntity userEntity, OrderItem orderItem, OrderType orderType) {
        return null;
    }

    @Override
    public Order getOrderByID(Long orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, UserEntity userEntity) {
        return List.of();
    }

    @Override
    public Order processOrder(Coin coin, double quantity, OrderType orderType, UserEntity userEntity) {
        return null;
    }
}
