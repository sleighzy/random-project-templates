package io.sleighzy.orders.service;

import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;
import io.sleighzy.inventory.rest.impl.dto.Inventory;
import io.sleighzy.orders.rest.impl.dto.Order;

public class OrdersService {

    private static final Logger LOGGER = LogManager.getLogger();

    @WithSpan
    public Set<Order> getOrders() {
        LOGGER.info("Retrieving orders");
        return ImmutableSet.of(new Order("1"), new Order("2"));
    }

    @WithSpan
    public Order getOrder(final String id) {
        Span.current().setAttribute("order.id", id);
        LOGGER.info("Retrieving order for id: {}", id);

        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("http://localhost:8080");
        LOGGER.info(target.path("/orders").request().get(String.class));

        return new Order(id);
    }

    @WithSpan
    public Order createOrder(final Order order) {
        Span.current().setAttribute("order.id", order.getId());
        LOGGER.info("Creating order");

        try {
            final Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
            final WebTarget target = client.target("http://localhost:8080/inventory");
            final Inventory inventory = target.path(order.getProductId()).request(MediaType.APPLICATION_JSON)
                    .get(Inventory.class);
            LOGGER.info(inventory);
        } catch (final Exception e) {
            LOGGER.error("Error creating order", e);
        }

        return order;
    }

    @WithSpan
    public Order updateOrder(final Order order) {
        Span.current().setAttribute("order.id", order.getId());
        LOGGER.info("Updating order");

        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("http://localhost:8080");
        LOGGER.info(target.path("/first-service").request().get(String.class));

        return order;
    }

    @WithSpan
    public Order deleteOrder(final String id) {
        Span.current().setAttribute("order.id", id);
        LOGGER.info("Deleting order for id: {}", id);

        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("http://localhost:8080");
        LOGGER.info(target.path("/first-service").request().get(String.class));

        return new Order(id);
    }
}
