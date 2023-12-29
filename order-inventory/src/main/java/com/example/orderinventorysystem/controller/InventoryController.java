package com.example.orderinventorysystem.controller;

import com.example.orderinventorysystem.domain.Inventory;
import com.example.orderinventorysystem.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> manageInventory(@RequestParam UUID productId, @RequestParam Integer quantity) {
        Inventory inventory = inventoryService.manageInventory(productId, quantity);
        return ResponseEntity.ok(inventory);
    }
}