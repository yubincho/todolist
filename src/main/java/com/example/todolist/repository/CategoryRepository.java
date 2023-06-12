package com.example.todolist.repository;

import com.example.todolist.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface  CategoryRepository extends JpaRepository<Category, Long>{


    @Query(value = "SELECT * from CATEGORY c where c.parent_id = 0", nativeQuery = true)
    List<Category> findAll();


}
