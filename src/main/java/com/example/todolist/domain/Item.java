package com.example.todolist.domain;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item extends DomainAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name", nullable = false, length = 10000)
    private String name;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String itemImage;

    // category
//    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private Set<CategoryBridge> categoryBridge = new HashSet<>();

    @Builder
    public Item(Long id, String name, Integer stock, Integer price, String description, String itemImage) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.itemImage = itemImage;
    }
}
