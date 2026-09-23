package io.sleighzy.inventory.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class RestServiceApplication {
    private static final Logger LOGGER = LogManager.getLogger(RestServiceApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Inventory Service Started");
        SpringApplication.run(RestServiceApplication.class, args);
    }
}
