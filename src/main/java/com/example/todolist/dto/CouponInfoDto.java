package com.example.todolist.dto;

import com.example.todolist.domain.Coupon;
import com.example.todolist.enums.CouponStatus;
import com.example.todolist.enums.CouponType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CouponInfoDto {

    private final String code;
    private final String name;
    private final CouponType type;
    private final CouponStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdAt;

    public static CouponInfoDto from(Coupon coupon) {
        return CouponInfoDto.builder()
                .code(coupon.getCouponCode())
                .name(coupon.getCouponName())
                .type(coupon.getCouponType())
                .status(coupon.getCouponStatus())
                .createdAt(coupon.getCreateAt())
                .build();
    }


}
