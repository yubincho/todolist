package com.example.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTestController {

    @GetMapping("/api")
    public String test() {
        return "test!!!";
    }
}
