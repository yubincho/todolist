package com.example.todolist.domain;

import com.example.todolist.enums.CategoryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends DomainAuditing {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Setter
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "title", nullable = false)
    private String title;

    private String ord;

    private String logo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CategoryStatus status;

//    @JsonIgnore
    @OneToMany(mappedBy = "parentId")
    private Set<Category> childCategorySet = new HashSet<>();

    // mapping table
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<CategoryBridge> categoryBridges = new HashSet<>();


    @Builder
    public Category(Long id, Long parentId, CategoryStatus status, String title, String ord, String logo) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.ord = ord;
        this.logo = logo;
        this.status = status;
    }

    public void addChildCategory(Category child) {
        this.childCategorySet.add(child);
        this.parentId = child.getId();
    }


}
