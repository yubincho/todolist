package com.example.todolist.repository;

import com.example.todolist.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TodolistRepository extends JpaRepository<TodoList, Long> {
}
