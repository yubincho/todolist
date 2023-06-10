package com.example.todolist.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@RequiredArgsConstructor
public enum CouponType {

    KOR("한국"),
    ENG("영어");

    private final String description;
}
