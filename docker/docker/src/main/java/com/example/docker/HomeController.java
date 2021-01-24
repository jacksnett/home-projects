package com.example.docker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}

