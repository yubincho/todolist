package com.example.todolist.controller;

import com.example.todolist.domain.TodoList;
import com.example.todolist.dto.RequestTodoDto;
import com.example.todolist.dto.ResponseTodoDto;
import com.example.todolist.repository.TodolistRepository;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodolistRepository todolistRepository;

    private final TodoService todoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseTodoDto> getOne(@PathVariable Long id) {

//        Optional<TodoList> one = todolistRepository.findById(id);
//        System.out.println(one);
////        return ResponseTodoDto.from(one.orElseThrow());
////        ResponseTodoDto res = ResponseTodoDto.from(one.orElseThrow());
//        ResponseTodoDto res = new ResponseTodoDto(one);
//        System.out.println(res);
//        return res;

        ResponseTodoDto one = todoService.getTodoOne(id);
        System.out.println(one);
        System.out.println("-----------");
        return new ResponseEntity<>(one, HttpStatus.OK);

    }

    @GetMapping("/get/all")
    public List<ResponseTodoDto> getAllList() {

        return todoService.getAll();

    }




//    @PostMapping("/post")
//    public TodoList save() {
//        TodoList todo = TodoList.builder()
//                .content("hello")
//                .build();
//        return todolistRepository.save(todo);
//    }


    @PostMapping("/post")
    public ResponseEntity<TodoList> create(@RequestBody RequestTodoDto dto) {

        TodoList newRes = RequestTodoDto.dtoToEntity(dto);

        TodoList saved = todolistRepository.save(newRes);
        System.out.println(saved);
        System.out.println("-----------");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);

    }


    @PostMapping("/update/{id}")
    public Optional<TodoList> update(@PathVariable Long id, @RequestBody RequestTodoDto dto) {

           return todoService.update(id, dto);

    }



}
