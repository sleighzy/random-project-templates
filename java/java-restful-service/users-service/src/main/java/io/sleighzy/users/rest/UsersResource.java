package io.sleighzy.users.rest;

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

import io.sleighzy.users.rest.impl.dto.User;
import io.sleighzy.users.service.UsersService;

@Path("")
public class UsersResource {
    private static final Logger LOGGER = LogManager.getLogger(UsersResource.class);

    private final UsersService usersService = new UsersService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        LOGGER.info("GET /users");
        final Set<User> users = this.usersService.getUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") final String id) {
        LOGGER.info("GET /users/:id");
        final User user = this.usersService.getUser(id);
        return Response.ok(user).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(final User user) {
        LOGGER.info("POST /users");
        final User newUser = this.usersService.createUser(user);
        return Response.ok(newUser).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(final User user) {
        LOGGER.info("PUT /users");
        final User updatedUser = this.usersService.updateUser(user);
        return Response.ok(updatedUser).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") final String id) {
        LOGGER.info("DELETE /users/:id");
        this.usersService.deleteUser(id);
        return Response.noContent().build();
    }
}
