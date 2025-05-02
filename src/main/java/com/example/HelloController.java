package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final CounterService counterService;

    public HelloController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/hello")
    public String hello() {
        counterService.increment();
        return "Hello, OCI K8s!";
    }
}