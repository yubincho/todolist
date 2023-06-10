package com.example.todolist.controller;

import com.example.todolist.dto.PageRequestDTO;
import com.example.todolist.dto.PageResultDTO;
import com.example.todolist.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/coupon")
    public ResponseEntity<PageResultDTO> list(PageRequestDTO pageRequestDTO) {

        return new ResponseEntity<>(couponService.getList(pageRequestDTO), HttpStatus.OK);
    }








}


