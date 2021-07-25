package io.sleighzy.inventory.service;

import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.google.common.collect.ImmutableSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;
import io.sleighzy.inventory.rest.impl.dto.Inventory;

public class InventoryService {

    private static final Logger LOGGER = LogManager.getLogger();

    @WithSpan
    public Set<Inventory> getInventory() {
        LOGGER.info("Retrieving all inventory");
        return ImmutableSet.of(new Inventory("1"), new Inventory("2"));
    }

    @WithSpan
    public Inventory getInventory(final String id) {
        Span.current().setAttribute("inventory.id", id);
        LOGGER.info("Retrieving inventory for id: {}", id);

        return new Inventory(id);
    }

    @WithSpan
    public Inventory createInventory(final Inventory inventory) {
        Span.current().setAttribute("inventory.id", inventory.getId());
        LOGGER.info("Creating inventory");

        return inventory;
    }

    @WithSpan
    public Inventory updateInventory(final Inventory inventory) {
        Span.current().setAttribute("inventory.id", inventory.getId());
        LOGGER.info("Updating inventory for id: {}", inventory.getId());

        return inventory;
    }

    @WithSpan
    public Inventory deleteInventory(final String id) {
        Span.current().setAttribute("inventory.id", id);
        LOGGER.info("Deleting inventory for id: {}", id);

        return new Inventory(id);
    }
}
