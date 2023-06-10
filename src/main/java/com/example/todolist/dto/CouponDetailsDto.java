package com.example.todolist.dto;

import com.example.todolist.domain.Coupon;
import com.example.todolist.enums.CouponStatus;
import com.example.todolist.enums.CouponType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CouponDetailsDto {

    private final String code;
    private final String name;
    private final CouponType type;
    private final CouponStatus status;
    private final LocalDateTime createdAt;

    public static CouponDetailsDto from(Coupon coupon) {
        return CouponDetailsDto.builder()
                .code(coupon.getCouponCode())
                .name(coupon.getCouponName())
                .type(coupon.getCouponType())
                .status(coupon.getCouponStatus())
                .createdAt(coupon.getCreateAt())
                .build();
    }

}
