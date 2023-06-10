package com.example.todolist.domain;

import com.example.todolist.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemEntityTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void insertDummies() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            ItemEntity itemEntity = ItemEntity.builder()
                    .name("name..." + i)
                    .stock(10 + i)
                    .price(1000 + i)
                    .description("Content ...")
                    .itemImage("image...")
                    .build();

            System.out.println(itemRepository.save(itemEntity));

        });
    }

}