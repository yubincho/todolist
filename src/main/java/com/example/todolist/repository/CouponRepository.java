package com.example.todolist.repository;

import com.example.todolist.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CouponRepository extends JpaRepository<Coupon, Long>, QuerydslPredicateExecutor<Coupon> {
}
