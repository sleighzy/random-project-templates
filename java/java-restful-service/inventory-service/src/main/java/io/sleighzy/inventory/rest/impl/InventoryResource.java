package io.sleighzy.inventory.rest.impl;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.sleighzy.inventory.rest.impl.dto.Inventory;
import io.sleighzy.inventory.service.InventoryService;

@RestController
public class InventoryResource {

    private static final Logger LOGGER = LogManager.getLogger(InventoryResource.class);

    private final InventoryService inventoryService = new InventoryService();

    @GetMapping("/inventory")
    public Set<Inventory> getInventory() {
        LOGGER.info("GET /inventory");
        final Set<Inventory> inventory = this.inventoryService.getInventory();
        return inventory;
    }

    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable("id") final String id) {
        LOGGER.info("GET /inventory/:id");
        final Inventory inventory = this.inventoryService.getInventory(id);
        return inventory;
    }

    @PostMapping("/inventory")
    public Inventory createInventory(@RequestBody final Inventory inventory) {
        LOGGER.info("POST /inventory");
        final Inventory newInventory = this.inventoryService.createInventory(inventory);
        return newInventory;
    }

    @PutMapping("/inventory/{id}")
    public Inventory updateInventory(@PathVariable("id") final String id, @RequestBody final Inventory inventory) {
        LOGGER.info("PUT /inventory/:id");
        final Inventory updatedInventory = this.inventoryService.updateInventory(id, inventory);
        return updatedInventory;
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable("id") final String id) {
        LOGGER.info("DELETE /inventory/:id");
        this.inventoryService.deleteInventory(id);
    }
}
