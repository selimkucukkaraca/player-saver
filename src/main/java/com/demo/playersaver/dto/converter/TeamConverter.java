package com.demo.playersaver.dto.converter;

import com.demo.playersaver.dto.TeamDto;
import com.demo.playersaver.dto.request.CreateTeamRequest;
import com.demo.playersaver.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    public TeamDto convertTeamToTeamDtoConverter(Team from) {
        return new TeamDto(
                from.getName(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Team toEntity(CreateTeamRequest request) {
        return new Team(
                request.getName()
        );
    }
}
