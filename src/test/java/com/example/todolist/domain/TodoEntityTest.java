package com.example.todolist.domain;

import com.example.todolist.repository.TodolistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TodoEntityTest {

    @Autowired
    private TodolistRepository todolistRepository;


    @Test
    void auditingTest() {

        TodoEntity todoEntity = new TodoEntity("first content");

        TodoEntity saved = todolistRepository.save(todoEntity);

        System.out.println("saved ###" + saved);
        System.out.println("createdat ###" + saved.getCreateAt());

    }

}