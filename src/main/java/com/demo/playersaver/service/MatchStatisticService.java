package com.demo.playersaver.service;

import com.demo.playersaver.dto.MatchStatisticDto;
import com.demo.playersaver.dto.converter.MatchStatisticConverter;
import com.demo.playersaver.dto.converter.PlayerConverter;
import com.demo.playersaver.dto.request.CreateMatchStatisticRequest;
import com.demo.playersaver.model.Player;
import com.demo.playersaver.repository.MatchStatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchStatisticService {

    private final MatchStatisticRepository matchStatisticRepository;
    private final MatchStatisticConverter matchStatisticConverter;
    private final PlayerService playerService;
    private final PlayerConverter playerConverter;

    public MatchStatisticService(MatchStatisticRepository matchStatisticRepository,
                                 MatchStatisticConverter matchStatisticConverter,
                                 PlayerService playerService,
                                 PlayerConverter playerConverter) {
        this.matchStatisticRepository = matchStatisticRepository;
        this.matchStatisticConverter = matchStatisticConverter;
        this.playerService = playerService;
        this.playerConverter = playerConverter;
    }

    public MatchStatisticDto save(CreateMatchStatisticRequest request){
        Player player = playerService.getPlayerByMail(request.getPlayerMail());

        var saved = matchStatisticConverter.toEntity(request, player);

        matchStatisticRepository.save(saved);
        return matchStatisticConverter.convertMatchStatisticToMatchStatisticDto(saved);
    }

    public List<MatchStatisticDto> getMatchStatisticByPlayerMail(String mail){
        Player player = playerService.getPlayerByMail(mail);

        return matchStatisticRepository.findMatchStatisticByPlayer(player)
                .stream()
                .map(matchStatistic -> new MatchStatisticDto(
                        matchStatistic.getPoint(),
                        matchStatistic.getEfficiencyScore(),
                        matchStatistic.getRebound(),
                        matchStatistic.getAssist(),
                        matchStatistic.getShootStatistic(),
                        matchStatistic.getTurnover(),
                        matchStatistic.getFoul(),
                        matchStatistic.getThreePoint(),
                        matchStatistic.getTwoPoint(),
                        matchStatistic.getOnePoint(),
                        playerConverter.convertPlayerToPlayerDto(matchStatistic.getPlayer())

                ))
                .collect(Collectors.toList());
    }

}
