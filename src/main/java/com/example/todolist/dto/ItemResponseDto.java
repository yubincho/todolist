package com.example.todolist.dto;

import com.example.todolist.domain.Item;
import com.example.todolist.domain.TodoEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ItemResponseDto {

    private Long id;

    private String name;
    private Integer price;

    private Integer stock;

    private String description;

    private String itemImage;

    public ItemResponseDto(Long id, String name, Integer price, Integer stock, String description, String itemImage) {
    }


    public static ItemResponseDto from(Item entity) {
        return new ItemResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStock(),
                entity.getDescription(),
                entity.getItemImage()
        );
    }

    public ItemResponseDto(Item one) {
        this.id = one.getId();
        this.name = one.getName();
        this.price = one.getPrice();
        this.stock = one.getStock();
        this.description = one.getDescription();
        this.itemImage = one.getItemImage();
    }
}
