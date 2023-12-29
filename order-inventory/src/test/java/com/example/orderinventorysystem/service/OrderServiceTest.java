package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.Order;
import com.example.orderinventorysystem.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.UUID;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void placeOrder() {
        UUID productId = UUID.randomUUID();
        Integer quantity = 10;
        Order order = new Order(null, productId, quantity, "PENDING", StatusType.PENDING);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.placeOrder(productId, quantity);

        assertNotNull(createdOrder);
        assertEquals(productId, createdOrder.getProductId());
        assertEquals(quantity, createdOrder.getQuantity());
        assertEquals("PENDING", createdOrder.getStatus());
    }

    // Additional tests for processOrder and updateDeliveryStatus can be added here
}