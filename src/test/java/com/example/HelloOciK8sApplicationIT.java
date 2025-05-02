package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloOciK8sApplicationIT {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private CounterService counterService;

    @Test
    public void fullContextHello() {
        String body = this.rest.getForObject("http://localhost:" + port + "/hello", String.class);
        assertThat(body).isEqualTo("Hello, OCI K8s!");
        // The counter should be at least 1 after the call
        assertThat(counterService.getCount()).isGreaterThanOrEqualTo(1);
    }
}