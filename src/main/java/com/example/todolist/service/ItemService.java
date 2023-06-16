package com.example.todolist.service;


import com.example.todolist.domain.Item;
import com.example.todolist.dto.ItemResponseDto;
import com.example.todolist.dto.ValidRequestDto;
import com.example.todolist.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;


    public ItemResponseDto register(ValidRequestDto dto) {

        if(dto.getName() == null || dto.getName().isBlank()) {
            throw new RuntimeException("Item name is required.");
        }

        Item newItem = new Item();
        newItem.setName(dto.getName());
        newItem.setPrice(dto.getPrice());
        newItem.setStock(dto.getStock());
        newItem.setDescription(dto.getDescription());
        newItem.setItemImage(dto.getItemImage());


        Item saved = itemRepository.save(newItem);

        ItemResponseDto result = new ItemResponseDto(saved);

        return result;
    }

    @Transactional(readOnly = true)
    public ItemResponseDto readOne(Long id) {

        Optional<Item> result = itemRepository.findById(id);

        return result.isPresent()? new ItemResponseDto(result.get()) : null;
    }


    @Transactional(readOnly = true)
    public List<ItemResponseDto> readAll() {

        List<Item> all = itemRepository.findAll();

        return all.stream().map(ItemResponseDto::new).collect(Collectors.toList());
    }


    public ItemResponseDto modify(ValidRequestDto dto, Long id) {

        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        item.modifyItem(dto);

        return new ItemResponseDto(item);

//        if(item.isPresent()) {
//            Item res = item.get();
//            Item newRes = itemRepository.save(res);
//            return new ItemResponseDto(newRes);
//        }

//        if (Objects.equals(item.get().getId(), id)) {
//            Item res = item.get();
//            Item newRes = itemRepository.save(res);
//            return new ItemResponseDto(newRes);
//        }
//        return new ItemResponseDto();

    }


    public void remove(Long id) {

        itemRepository.deleteById(id);

    }
}
