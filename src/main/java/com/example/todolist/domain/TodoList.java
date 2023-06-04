package com.example.todolist.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "todo_list")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todolist_id")
    private Long id;

    @Setter
    @Column(nullable = false, length = 10000)
    private String content;

    @Builder
    public TodoList(String content) {
        this.content = content;
    }

//    public TodoList(Long id, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
//        super();
//    }

    // dto -> entity
//    public static TodoList dtoToEntity(TodoDto dto) {
//        return new TodoList(
//                dto.getId(),
//                dto.getContent(),
//                dto.getCreatedAt(),
//                dto.getModifiedAt()
//        );
//    }

}
