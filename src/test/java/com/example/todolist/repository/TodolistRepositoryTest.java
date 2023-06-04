package com.example.todolist.repository;

import com.example.todolist.domain.TodoList;
import com.example.todolist.service.TodoService;
import org.assertj.core.api.ThrowableTypeAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;


@SpringBootTest
class TodolistRepositoryTest {

    @Autowired
    private TodolistRepository todolistRepository;

    @Autowired
    private TodoService todoService;

    private EntityManager em;

    @Transactional
    @Test
    void save() {

//        TodoList newlist1 = new TodoList("akdhakf");
//
////        TodoList saved = todolistRepository.saveAndFlush(newlist1);
//
//        TodoList saved = todoService.save(newlist1);
//
////        em.persist(todolistRepository.save(newlist1));
//
//        Optional<TodoList> findOne = todolistRepository.findById(saved.getId());
//
//        if (findOne.isPresent()) {
//            assertThat(findOne.get().getContent()).isEqualTo("akdhakf");
////            System.out.print("findOne ###");
////            System.out.println(findOne);
//        }
//        System.out.print("findOne ###");
//        System.out.println(findOne);

    }
}