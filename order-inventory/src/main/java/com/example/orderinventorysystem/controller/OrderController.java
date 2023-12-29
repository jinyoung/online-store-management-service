package com.example.orderinventorysystem.controller;

import com.example.orderinventorysystem.domain.Order;
import com.example.orderinventorysystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestParam UUID productId, @RequestParam Integer quantity) {
        Order order = orderService.placeOrder(productId, quantity);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}/process")
    public ResponseEntity<Order> processOrder(@PathVariable UUID orderId) {
        Order order = orderService.processOrder(orderId);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{orderId}/delivery-status")
    public ResponseEntity<Order> updateDeliveryStatus(@PathVariable UUID orderId, @RequestParam String status) {
        Order order = orderService.updateDeliveryStatus(orderId, status);
        return ResponseEntity.ok(order);
    }
}