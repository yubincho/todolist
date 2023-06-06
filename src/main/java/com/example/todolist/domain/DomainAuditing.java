package com.example.todolist.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class DomainAuditing {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    @Column(name="CREATEDAT", nullable = false, updatable = false)
    private LocalDateTime createAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @LastModifiedDate
    @Column(name="MODIFIEDAT", nullable = false)
    private LocalDateTime modifiedAt;



}
