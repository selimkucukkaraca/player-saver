package com.demo.playersaver.service;

import com.demo.playersaver.dto.TeamDto;
import com.demo.playersaver.dto.converter.TeamConverter;
import com.demo.playersaver.dto.request.CreateTeamRequest;
import com.demo.playersaver.exception.NotFountException;
import com.demo.playersaver.model.Team;
import com.demo.playersaver.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;

    public TeamService(TeamRepository teamRepository,
                       TeamConverter teamConverter) {
        this.teamRepository = teamRepository;
        this.teamConverter = teamConverter;
    }

    public TeamDto save(CreateTeamRequest request) {
        var saved = teamConverter.toEntity(request);

        if (!teamRepository.existsTeamByName(saved.getName())) {
            teamRepository.save(saved);
        }

        return teamConverter.convertTeamToTeamDtoConverter(saved);
    }

    public void delete(String name) {
        var team = getTeamByName(name);

        teamRepository.deleteById(team.getId());
    }

    public TeamDto getByName(String name) {
        return teamConverter.convertTeamToTeamDtoConverter(getTeamByName(name));
    }

    protected Team getTeamByName(String name) {
        return teamRepository.findTeamByName(name)
                .orElseThrow(() -> new NotFountException("Team not fount, team name: " + name));
    }
}
