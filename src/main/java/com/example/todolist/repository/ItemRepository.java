package com.example.todolist.repository;

import com.example.todolist.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>, QuerydslPredicateExecutor<ItemEntity> {
}
