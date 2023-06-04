package com.example.todolist.service;

import com.example.todolist.domain.TodoList;
import com.example.todolist.dto.RequestTodoDto;
import com.example.todolist.dto.ResponseTodoDto;
import com.example.todolist.repository.TodolistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class TodoService {

    private final TodolistRepository todolistRepository;

//    private static List<TodoList> todoLists = new ArrayList<>();
//
//    static {
//        todoLists.add(new TodoList(1L, "hellos"));
//        todoLists.add(new TodoList(2L, "hello hi"));
//    }

//    public Long save(TodoDto todoDto) {
//        TodoList entity = TodoList.dtoToEntity(todoDto);
//        todolistRepository.saveAndFlush(entity);
//        System.out.println(entity);
//        return null;
//    }

    @Transactional(readOnly = true)
    public ResponseTodoDto getTodoOne(Long id) {

//        Optional<TodoList> one = todolistRepository.findById(id);
//        System.out.println(one);
//        ResponseTodoDto result = ResponseTodoDto.from(one.orElseThrow());
//
//        return result;

        Optional<TodoList> one = todolistRepository.findById(id);
        System.out.println(one);
//        return ResponseTodoDto.from(one.orElseThrow());
//        ResponseTodoDto res = ResponseTodoDto.from(one.orElseThrow());
        ResponseTodoDto res = new ResponseTodoDto(one);
//        System.out.println(res);
        return res;
    }

    @Transactional(readOnly = true)
    public List<ResponseTodoDto> getAll() {

        List<TodoList> lists = todolistRepository.findAll();

        return lists.stream().map(v -> new ResponseTodoDto(Optional.ofNullable(v))).collect(Collectors.toList());

    }


    public Optional<TodoList> update(Long id, RequestTodoDto dto) {

        Optional<TodoList> find = todolistRepository.findById(id);

        if (Objects.equals(find.get().getId(), id)) {
            find.get().setContent(dto.getContent());
//            todolistRepository.save(find);
        }

       return find;

    }




}
