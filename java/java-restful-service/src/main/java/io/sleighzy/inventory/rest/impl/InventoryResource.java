package io.sleighzy.inventory.rest.impl;

import java.util.Set;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.sleighzy.inventory.rest.impl.dto.Inventory;
import io.sleighzy.inventory.service.InventoryService;

@Path("/inventory")
public class InventoryResource {

    private static final Logger LOGGER = LogManager.getLogger(InventoryResource.class);

    private final InventoryService inventoryService = new InventoryService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventory() {
        LOGGER.info("GET /inventory");
        final Set<Inventory> inventory = this.inventoryService.getInventory();
        return Response.ok(inventory).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventory(@PathParam("id") final String id) {
        LOGGER.info("GET /inventory/:id");
        final Inventory inventory = this.inventoryService.getInventory(id);
        return Response.ok(inventory).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInventory(final Inventory inventory) {
        LOGGER.info("POST /inventory");
        final Inventory newInventory = this.inventoryService.createInventory(inventory);
        return Response.ok(newInventory).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInventory(final Inventory inventory) {
        LOGGER.info("PUT /inventory");
        final Inventory updatedInventory = this.inventoryService.updateInventory(inventory);
        return Response.ok(updatedInventory).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteInventory(@PathParam("id") final String id) {
        LOGGER.info("DELETE /inventory/:id");
        this.inventoryService.deleteInventory(id);
        return Response.noContent().build();
    }
}
