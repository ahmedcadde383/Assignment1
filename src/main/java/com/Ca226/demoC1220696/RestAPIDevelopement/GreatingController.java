package com.Ca226.demoC1220696.RestAPIDevelopement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreatingController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }


    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}


