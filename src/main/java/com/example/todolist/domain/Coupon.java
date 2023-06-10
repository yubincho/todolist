package com.example.todolist.domain;

import com.example.todolist.enums.CouponStatus;
import com.example.todolist.enums.CouponType;
import com.querydsl.core.types.EntityPath;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@Entity
@Getter
@Table(name = "coupons")
@ToString
public class Coupon extends DomainAuditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", nullable = false)
    private CouponStatus couponStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", nullable = false)
    private CouponType couponType;

    public Coupon() {
    }

    @Builder
    public Coupon(String couponCode, String couponName, CouponStatus couponStatus, CouponType couponType) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.couponStatus = couponStatus;
        this.couponType = couponType;
    }

}