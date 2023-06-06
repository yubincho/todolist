package com.example.todolist.paging;

import com.example.todolist.domain.TodoEntity;
import com.example.todolist.repository.TodolistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@SpringBootTest
public class PagingTests {

    @Autowired
    private TodolistRepository todolistRepository;


    @Test
    void testPageDefault() {

        Pageable pageable = PageRequest.of(0,10);

        Page<TodoEntity> result = todolistRepository.findAll(pageable);

        System.out.println(result);

    }


    @Test
    void testQueryMethodWithPage() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<TodoEntity> result = (Page<TodoEntity>) todolistRepository.findByIdBetween(10L, 50L, pageable);

        result.get().forEach(id -> System.out.println("id ###" + id));
    }



}
