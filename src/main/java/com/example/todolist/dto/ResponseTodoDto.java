package com.example.todolist.dto;

import com.example.todolist.domain.TodoList;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
public class ResponseTodoDto {

    private Long id;

    private String content;

//    private LocalDateTime createdAt;
//
//    private LocalDateTime modifiedAt;

    public ResponseTodoDto(Long id, String content) {
    }

//    public ResponseTodoDto(TodoList entity) {
//        this.id = entity.getId();
//        this.content = entity.getContent();
//    }


    // entity -> dto
    public ResponseTodoDto(Optional<TodoList> one) {
        this.id = one.get().getId();
        this.content = one.get().getContent();
    }


    // entity -> dto
    public static ResponseTodoDto from(TodoList entity) {
        return new ResponseTodoDto(
                entity.getId(),
                entity.getContent()
        );
    }


}

