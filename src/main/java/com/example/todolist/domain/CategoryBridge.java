package com.example.todolist.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.stream.Collectors;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryBridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bridge_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public <R> CategoryBridge(Long id, Long parentId, String title, String ord, R collect) {
    }


    public static CategoryBridge of(Category category, Item itemEntity) {
        return new CategoryBridge(
                category.getId(),
                category.getParentId(),
                category.getTitle(),
                category.getOrd(),
                category.getChildCategorySet().stream().distinct().filter(v -> v.getId() == 1).collect(Collectors.toSet())
                );
//                itemEntity.getId(),
//                itemEntity.getName(),
    }
}




