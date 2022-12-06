package com.demo.playersaver.dto.converter;

import com.demo.playersaver.dto.PlayerDto;
import com.demo.playersaver.dto.request.CreatePlayerRequest;
import com.demo.playersaver.model.Player;
import com.demo.playersaver.model.Team;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    private final TeamConverter teamConverter;

    public PlayerConverter(TeamConverter teamConverter) {
        this.teamConverter = teamConverter;
    }

    public PlayerDto convertPlayerToPlayerDto(Player from) {
        return new PlayerDto(
                from.getName(),
                from.getLastname(),
                from.getMail(),
                from.getAge(),
                teamConverter.convertTeamToTeamDtoConverter(from.getTeam()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Player toEntity(CreatePlayerRequest request, Team team) {
        return new Player(
                request.getName(),
                request.getLastname(),
                request.getMail(),
                request.getAge(),
                team
        );
    }
}
