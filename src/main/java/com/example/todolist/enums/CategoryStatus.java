package com.example.todolist.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryStatus {

    //    PRIVATE("비공개"),
    REMOVE("삭제"),
    PUBLIC("공개"),
    ;

    private final String description;

}
