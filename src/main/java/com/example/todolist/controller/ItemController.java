package com.example.todolist.controller;

import com.example.todolist.dto.ItemResponseDto;
import com.example.todolist.dto.ValidRequestDto;
import com.example.todolist.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api2")
public class ItemController {


    private final ItemService itemService;


    @GetMapping("/get")
    public ResponseEntity<List<ItemResponseDto>> findAll() {

        return new ResponseEntity<>(itemService.readAll(), HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<ItemResponseDto> findOnd(@PathVariable Long id) {

        return new ResponseEntity<>(itemService.readOne(id), HttpStatus.OK);

    }


    @PostMapping("/valid")
    public ResponseEntity<ItemResponseDto> register(@Validated @RequestBody ValidRequestDto dto) {

        return new ResponseEntity<>(itemService.register(dto), HttpStatus.CREATED);

    }


    @PostMapping("/modify/{id}")
    public ResponseEntity<ItemResponseDto> modify(@RequestBody ValidRequestDto dto, @PathVariable Long id) {

        return new ResponseEntity<>(itemService.modify(dto,id), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

         itemService.remove(id);
         return "Remove completed.";
    }

}
