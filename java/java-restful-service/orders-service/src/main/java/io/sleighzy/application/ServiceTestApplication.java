package io.sleighzy.application;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

import io.sleighzy.orders.rest.impl.OrdersResource;

public class ServiceTestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(OrdersResource.class);
        return set;
    }
}
