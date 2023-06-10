package com.example.todolist.dto;

import com.example.todolist.domain.Coupon;
import com.example.todolist.enums.CouponStatus;
import com.example.todolist.enums.CouponType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponCreateRequestDto {

    private String couponCode;

    private String couponName;

    private CouponType couponType;

    public Coupon toEntity() {
        return Coupon.builder()
                .couponCode(couponCode)
                .couponName(couponName)
                .couponStatus(CouponStatus.UNUSED)
                .couponType(couponType)
                .build();
    }
}
