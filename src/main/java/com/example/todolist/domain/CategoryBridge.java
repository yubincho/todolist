package com.example.todolist.domain;

import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.LAZY;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class CategoryBridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bridge_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    public <R> CategoryBridge(Long id, Long parentId, String title, String ord, R collect) {
    }


    public static CategoryBridge of(Category category, ItemEntity itemEntity) {
        return new CategoryBridge(
                category.getId(),
                category.getParentId(),
                category.getTitle(),
                category.getOrd(),
                category.getChildCategorySet().stream().collect(Collectors.toSet())
                );
//                itemEntity.getId(),
//                itemEntity.getName(),

    }
}




