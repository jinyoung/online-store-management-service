package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EventPublisherService {

    private final Source source;

    @Autowired
    public EventPublisherService(Source source) {
        this.source = source;
    }

    public void publishOrderPlacedEvent(Order order) {
        source.output().send(MessageBuilder.withPayload(order).build());
    }

    // Additional methods to publish other events can be added here
}