package io.sleighzy.inventory.rest.impl;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.sleighzy.inventory.rest.impl.dto.Inventory;
import io.sleighzy.inventory.service.InventoryService;

@Path("/inventory")
public class InventoryResource {

    private static final Logger LOGGER = LogManager.getLogger();

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
