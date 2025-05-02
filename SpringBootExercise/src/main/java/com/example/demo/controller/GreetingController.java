package com.example.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
            .header("Custom-Header", "value")
            .body("Success with custom header!");
    }

    @GetMapping("/not-found")
    public ResponseEntity<Map<String, String>> notFound() {
        Map<String, String> error = Map.of("error", "Resource not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        URI location = URI.create("/resource/1");
        return ResponseEntity.created(location).body("Resource created");
    }
}