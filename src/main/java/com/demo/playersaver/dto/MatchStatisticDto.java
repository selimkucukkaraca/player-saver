package com.demo.playersaver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchStatisticDto {

    private int point;
    private double efficiencyScore;
    private int rebound;
    private int assist;
    private String shootStatistic;
    private int turnover;
    private int foul;
    private int threePoint;
    private int twoPoint;
    private int onePoint;
    private PlayerDto playerDto;

}
