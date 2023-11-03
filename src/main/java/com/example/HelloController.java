package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path="/")
    String hello() {
        return "Hello World, Spring Boot!";
    }


    @GetMapping(path="/qaautomation")
    String qaautomation() {
        return "Hello QA Automation!";
    }

}