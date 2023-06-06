package com.example.todolist.dto;

import com.example.todolist.domain.TodoEntity;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTodoDto {



    private String content;


    // dto -> entity
    public static TodoEntity dtoToEntity(RequestTodoDto dto) {
        return new TodoEntity(
//              dto.get
             dto.getContent()
        );
    }

//    private LocalDateTime createdAt;
//
//    private LocalDateTime modifiedAt;


    // dto -> entity
//    public static TodoEntity dtoToEntity(RequestTodoDto dto) {
//        return new TodoEntity(
////                dto.getId(),
//                dto.getContent()
//        );


}