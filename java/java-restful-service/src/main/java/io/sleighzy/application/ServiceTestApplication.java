package io.sleighzy.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.sleighzy.inventory.rest.impl.InventoryResource;
import io.sleighzy.orders.rest.impl.OrdersResource;

public class ServiceTestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(OrdersResource.class);
        set.add(InventoryResource.class);
        return set;
    }
}
