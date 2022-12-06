package com.demo.playersaver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PlayerDto {
    private String name;
    private String lastname;
    private String mail;
    private int age;
    private TeamDto team;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
