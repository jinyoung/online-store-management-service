package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.Order;
import com.example.orderinventorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(UUID productId, Integer quantity) {
        Order order = Order.builder()
                .productId(productId)
                .quantity(quantity)
                .status("PENDING")
                .statusType(StatusType.PENDING)
                .build();
        return orderRepository.save(order);
    }

    public Order processOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("PROCESSED");
        order.setStatusType(StatusType.PROCESSED);
        return orderRepository.save(order);
    }

    public Order updateDeliveryStatus(UUID orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        order.setStatusType(StatusType.valueOf(status.toUpperCase()));
        return orderRepository.save(order);
    }
}