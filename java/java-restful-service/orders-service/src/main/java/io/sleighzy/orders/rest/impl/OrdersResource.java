package io.sleighzy.orders.rest.impl;

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

import io.sleighzy.orders.rest.impl.dto.Order;
import io.sleighzy.orders.service.OrdersService;

@Path("/orders")
public class OrdersResource {

    private static final Logger LOGGER = LogManager.getLogger(OrdersResource.class);

    private final OrdersService ordersService = new OrdersService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {
        LOGGER.info("GET /orders");
        final Set<Order> orders = this.ordersService.getOrders();
        return Response.ok(orders).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrder(@PathParam("id") final String id) {
        LOGGER.info("GET /orders/:id");
        final Order order = this.ordersService.getOrder(id);
        return Response.ok(order).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(final Order order) {
        LOGGER.info("POST /orders");
        final Order newOrder = this.ordersService.createOrder(order);
        return Response.ok(newOrder).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(final Order order) {
        LOGGER.info("PUT /orders");
        final Order updatedOrder = this.ordersService.updateOrder(order);
        return Response.ok(updatedOrder).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrder(@PathParam("id") final String id) {
        LOGGER.info("DELETE /orders/:id");
        this.ordersService.deleteOrder(id);
        return Response.noContent().build();
    }
}
