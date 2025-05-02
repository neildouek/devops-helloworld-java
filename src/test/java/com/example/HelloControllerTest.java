package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class HelloControllerTest {

    private WebTestClient webClient;
    private CounterService counterService;

    @BeforeEach
    public void setUp() {
        counterService = Mockito.mock(CounterService.class);
        HelloController controller = new HelloController(counterService);
        webClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    public void helloReturnsExpected() {
        webClient.get().uri("/hello")
                 .accept(MediaType.TEXT_PLAIN)
                 .exchange()
                 .expectStatus().isOk()
                 .expectBody(String.class).isEqualTo("Hello, OCI K8s!");

        Mockito.verify(counterService).increment();
    }
}