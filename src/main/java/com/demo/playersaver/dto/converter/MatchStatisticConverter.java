package com.demo.playersaver.dto.converter;

import com.demo.playersaver.dto.MatchStatisticDto;
import com.demo.playersaver.dto.request.CreateMatchStatisticRequest;
import com.demo.playersaver.model.MatchStatistic;
import com.demo.playersaver.model.Player;
import org.springframework.stereotype.Component;

@Component
public class MatchStatisticConverter {

    private final PlayerConverter playerConverter;

    public MatchStatisticConverter(PlayerConverter playerConverter) {
        this.playerConverter = playerConverter;
    }

    public MatchStatisticDto convertMatchStatisticToMatchStatisticDto(MatchStatistic from){
        return new MatchStatisticDto(
                from.getPoint(),
                from.getEfficiencyScore(),
                from.getRebound(),
                from.getAssist(),
                from.getShootStatistic(),
                from.getTurnover(),
                from.getFoul(),
                from.getThreePoint(),
                from.getTwoPoint(),
                from.getOnePoint(),
                playerConverter.convertPlayerToPlayerDto(from.getPlayer())
        );
    }

    public MatchStatistic toEntity(CreateMatchStatisticRequest request, Player player){
        int totalPoint = ((request.getThreePoint() * 3) + (request.getTwoPoint() * 2) + (request.getOnePoint()));

        return new MatchStatistic(
                request.getEfficiencyScore(),
                totalPoint,
                request.getRebound(),
                request.getAssist(),
                request.getShootStatistic(),
                request.getTurnover(),
                request.getFoul(),
                request.getThreePoint(),
                request.getTwoPoint(),
                request.getOnePoint(),
                player
        );
    }

}
