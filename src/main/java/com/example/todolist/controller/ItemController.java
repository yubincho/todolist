package com.example.todolist.controller;

import com.example.todolist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api2")
public class ItemController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }
}
