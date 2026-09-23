package io.sleighzy.inventory.rest.service;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
public class InventoryServiceControllerTests {

  @Autowired
  private RestTestClient restTestClient;

  @Test
  public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

    this.restTestClient.get().uri("/inventory")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.content").isEqualTo("{ \"id\": \"1\" }");
  }

  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {

    this.restTestClient.get()
        .uri(uri -> uri.path("/inventory").queryParam("id", "1").build())
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.content").isEqualTo("{ \"id\": \"1\" }");
  }

}
