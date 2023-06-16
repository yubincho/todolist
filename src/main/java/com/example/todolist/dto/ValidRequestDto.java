package com.example.todolist.dto;

import com.example.todolist.domain.Item;
import com.example.todolist.domain.TodoEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@Data
@NoArgsConstructor(force = true)
public class ValidRequestDto {

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stock;

    @Nullable
    private String description;

    @Nullable
    private String itemImage;

    @Builder
    public ValidRequestDto(String name, Integer price, Integer stock, String description, String itemImage) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.itemImage = itemImage;
    }

    public static Item dtoToEntity(ValidRequestDto dto) {
        return new Item(
                dto.getName(),
                dto.getPrice(),
                dto.getStock(),
                dto.getDescription(),
                dto.getItemImage());

    }

}
