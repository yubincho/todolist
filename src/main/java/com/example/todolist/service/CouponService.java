package com.example.todolist.service;

import com.example.todolist.domain.Coupon;
import com.example.todolist.domain.QCoupon;

import com.example.todolist.dto.CouponInfoDto;
import com.example.todolist.dto.PageRequestDTO;
import com.example.todolist.dto.PageResultDTO;

import com.example.todolist.enums.CouponType;
import com.example.todolist.repository.CouponRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.function.Function;



@Log4j2
@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @PersistenceContext
    EntityManager em;


    public PageResultDTO<CouponInfoDto, Coupon> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());

        Page<Coupon> result = couponRepository.findAll(pageable);

        Function<Coupon, CouponInfoDto> fn = (CouponInfoDto::from);

        return new PageResultDTO<>(result, fn);
    }


//    private Boolean getSearch(PageRequestDTO requestDTO) {
//
//        String type = requestDTO.getCoupon_type();
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        QCoupon qCoupon = QCoupon.coupon;
//
////        String keyword = requestDTO.getKeyword();
//
//        BooleanExpression expression = qCoupon.id.gt(0L);
//
//        booleanBuilder.and(expression);
//
//        if (type == null || type.trim().length() == 0) {
//            return booleanBuilder.hasValue();
//        }
//
//
//        BooleanBuilder conditionBuilder = new BooleanBuilder();
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//        Coupon coupon = new Coupon();
//        StringExpression formattedDate = Expressions.stringTemplate("FUNCTION('DATE_FORMAT', {0}, '%Y-%m-%d')", coupon.getCreateAt());
//
////        if(type.contains("t")){
////            conditionBuilder.or(qCoupon.couponName.contains(keyword));
////        }
////        if(type.contains("c")){
////            conditionBuilder.or(qCoupon.couponCode.contains(keyword));
////        }
//
//
//        if (requestDTO.getCoupon_type() != null) {
//            booleanBuilder.and(qCoupon.couponType.eq(CouponType.valueOf(requestDTO.getCoupon_type())));
//        }
//
//        if (requestDTO.getStartAt() != null && requestDTO.getEndAt() != null) {
//
//            JPAQuery<Coupon> query = (JPAQuery<Coupon>) queryFactory
//                    .selectFrom(qCoupon)
//                    .where(qCoupon.couponType.eq(CouponType.valueOf(type)))
//                    .where(formattedDate.eq(requestDTO.getStartAt()),
//                            formattedDate.eq(requestDTO.getEndAt()))
//                    .fetch();
//
//            booleanBuilder.and(qCoupon.eq(query));
//        }
//
////        if (requestDTO.getCoupon_type() != null) {
////            booleanBuilder.and(qCoupon.couponType.eq(CouponType.valueOf(requestDTO.getCoupon_type())));
////        }
////
////        if (requestDTO.getStartAt() != null && requestDTO.getEndAt() != null) {
////            booleanBuilder.and(
////                    formattedDate.between(
////                            Expressions.asString(requestDTO.getStartAt()),
////                            Expressions.asString(requestDTO.getEndAt())
////                    )
////            );
////        }
//
////
////        LocalDateTime startAt = requestDTO.getStartAt();
////        LocalDateTime endAt = requestDTO.getEndAt();
//////        if (requestDTO.getStartAt() != null && requestDTO.getEndAt() != null) {
////        if (startAt != null && endAt != null) {
////            booleanBuilder.and(qCoupon.createAt.between(startAt, endAt));
////
////        }
//
//            //모든 조건 통합
//            booleanBuilder.and(conditionBuilder);
//            return booleanBuilder.hasValue();
//
//    }

}
