package com.example.orderinventorysystem.service;

import com.example.orderinventorysystem.domain.Inventory;
import com.example.orderinventorysystem.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory manageInventory(UUID productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findById(productId)
                .orElse(Inventory.builder().productId(productId).quantity(0).build());
        inventory.setQuantity(inventory.getQuantity() + quantity);
        return inventoryRepository.save(inventory);
    }
}