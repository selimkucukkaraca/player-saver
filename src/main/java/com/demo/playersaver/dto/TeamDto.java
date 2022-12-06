package com.demo.playersaver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TeamDto {
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
