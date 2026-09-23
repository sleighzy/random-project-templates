package io.sleighzy.users.service;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.WithSpan;
import io.sleighzy.users.rest.impl.dto.User;

public class UsersService {

    private static final Logger LOGGER = LogManager.getLogger(UsersService.class);

    @WithSpan
    public Set<User> getUsers() {
        LOGGER.info("Retrieving users");
        return ImmutableSet.of(new User("1"), new User("2"));
    }

    @WithSpan
    public User getUser(final String id) {
        Span.current().setAttribute("user.id", id);
        LOGGER.info("Retrieving user for id: {}", id);

        return new User(id);
    }

    @WithSpan
    public User createUser(final User user) {
        Span.current().setAttribute("user.id", user.getId());
        LOGGER.info("Creating user");

        return user;
    }

    @WithSpan
    public User updateUser(final User user) {
        Span.current().setAttribute("user.id", user.getId());
        LOGGER.info("Updating user");

        return user;
    }

    @WithSpan
    public User deleteUser(final String id) {
        Span.current().setAttribute("user.id", id);
        LOGGER.info("Deleting user for id: {}", id);

        return new User(id);
    }
}
