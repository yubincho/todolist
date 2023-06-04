package com.example.todolist;

import com.example.todolist.domain.TodoList;
import com.example.todolist.repository.TodolistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;

    public void init() { initService.dbInit(); }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        private final TodolistRepository todolistRepository;

        public void dbInit() {

//            TodoList todo1 = new TodoList("hello");
//
//            TodoList todo2 = new TodoList("sljlgjdf;gzdg");
//
//            TodoList todo3 = new TodoList("dkdg");

            TodoList todo1 = new TodoList("hello hi");

            todolistRepository.save(todo1);

            em.persist(todo1);
//            em.persist(todo2);

//            em.flush();
//            em.clear();

        }




    }





}
