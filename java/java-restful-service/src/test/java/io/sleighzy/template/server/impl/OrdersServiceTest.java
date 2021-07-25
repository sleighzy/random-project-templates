package io.sleighzy.template.server.impl;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.sleighzy.application.ServiceTestApplication;

public class OrdersServiceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        ResourceConfig rc = ResourceConfig.forApplication(new ServiceTestApplication());
        URI uri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        server = GrizzlyHttpServerFactory.createHttpServer(uri, rc);

        final Client client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetOrderOne() {
        String responseMsg = target.path("/orders/1").request().get(String.class);
        assertEquals("{\"id\":\"1\",\"userId\":null,\"productId\":null,\"status\":null,\"createdAt\":null,\"updatedAt\":null}",
                responseMsg);
    }
}
