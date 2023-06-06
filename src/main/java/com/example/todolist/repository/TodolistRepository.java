package com.example.todolist.repository;

import com.example.todolist.domain.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TodolistRepository extends JpaRepository<TodoEntity, Long> {
    Page<TodoEntity> findByIdBetween(long l, long l1, Pageable pageable);


}
