package com.demo.playersaver.dto.request;

import lombok.Data;

@Data
public class CreateMatchStatisticRequest {
    private double efficiencyScore;
    private int rebound;
    private int assist;
    private String shootStatistic;
    private int turnover;
    private int foul;
    private int threePoint;
    private int twoPoint;
    private int onePoint;
    private String playerMail;

}
