package com.demo.playersaver.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate;
}
