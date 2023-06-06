package com.example.todolist.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Getter @Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "todo_list")
@Entity
public class TodoEntity extends DomainAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todolist_id")
    private Long id;

    @Setter
    @Column(nullable = false, length = 10000)
    private String content;


    public TodoEntity(String content) {
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
