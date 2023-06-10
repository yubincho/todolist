package com.example.todolist.domain;

import com.example.todolist.enums.CouponStatus;
import com.example.todolist.enums.CouponType;
import com.example.todolist.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponTest {

    @Autowired
    private CouponRepository couponRepository;

    @Test
    void insertDummies() {
        IntStream.rangeClosed(30, 32).forEach(i -> {
            Coupon couponEntity = Coupon.builder()
                    .couponCode("code ..." + i)
                    .couponName("coupon name..." + i)
                    .couponStatus(CouponStatus.UNUSED)
                    .couponType(CouponType.ENG)
                    .build();

            System.out.println(couponRepository.save(couponEntity));

        });
    }

}