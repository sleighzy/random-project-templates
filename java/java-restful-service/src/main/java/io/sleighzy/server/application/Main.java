package io.sleighzy.server.application;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import io.sleighzy.application.ServiceTestApplication;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(final String... args) {
        startServer();
    }

    private static void startServer() {
        ResourceConfig config = ResourceConfig.forApplication(new ServiceTestApplication());
        config.register(JacksonFeature.class);
        URI uri = UriBuilder.fromUri("http://0.0.0.0/").port(8080).build();

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config, false);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        try {
            server.start();
        } catch (IOException e) {
            LOGGER.fatal("Error starting server", e);
        }
    }

}
