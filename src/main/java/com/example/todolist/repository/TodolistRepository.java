package com.example.todolist.repository;

import com.example.todolist.domain.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface TodolistRepository extends JpaRepository<TodoEntity, Long>, QuerydslPredicateExecutor<TodoEntity> {
    Page<TodoEntity> findByIdBetween(long l, long l1, Pageable pageable);


}
