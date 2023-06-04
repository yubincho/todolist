package com.example.todolist.dto;

import com.example.todolist.domain.TodoList;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTodoDto {



    private String content;

//    private LocalDateTime createdAt;
//
//    private LocalDateTime modifiedAt;


    // dto -> entity
    public static TodoList dtoToEntity(RequestTodoDto dto) {
        return new TodoList(
//                dto.getId(),
                dto.getContent()
        );
    }

}