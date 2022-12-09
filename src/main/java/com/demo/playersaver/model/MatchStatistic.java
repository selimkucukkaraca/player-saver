package com.demo.playersaver.model;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MatchStatistic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    @ManyToOne
    private Player player;

    public MatchStatistic(double efficiencyScore,
                          int point,
                          int rebound,
                          int assist,
                          String shootStatistic,
                          int turnover,
                          int foul,
                          int threePoint,
                          int twoPoint,
                          int onePoint,
                          Player player
    ) {
        this.efficiencyScore = efficiencyScore;
        this.point = point;
        this.rebound = rebound;
        this.assist = assist;
        this.shootStatistic = shootStatistic;
        this.turnover = turnover;
        this.foul = foul;
        this.threePoint = threePoint;
        this.twoPoint = twoPoint;
        this.onePoint = onePoint;
        this.player = player;
    }
}
