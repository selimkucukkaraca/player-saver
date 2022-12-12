package com.demo.playersaver.service;

import com.demo.playersaver.dto.TeamDto;
import com.demo.playersaver.dto.converter.TeamConverter;
import com.demo.playersaver.dto.request.CreateTeamRequest;
import com.demo.playersaver.model.Team;
import com.demo.playersaver.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TeamServiceTest {

    private TeamRepository teamRepository;
    private TeamConverter teamConverter;

    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        teamRepository = mock(TeamRepository.class);
        teamConverter = mock(TeamConverter.class);

        teamService = new TeamService(teamRepository, teamConverter);
    }

    @Test
    public void testSave_itShouldReturnTeamDto() {
        CreateTeamRequest request = mock(CreateTeamRequest.class);
        request.setName("test");

        Team team = new Team("test");

        TeamDto teamDto = new TeamDto(
                "test",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(teamConverter.toEntity(request)).thenReturn(team);
        when(teamRepository.existsTeamByName("test")).thenReturn(false);
        when(teamRepository.save(team)).thenReturn(team);
        when(teamConverter.convertTeamToTeamDtoConverter(team)).thenReturn(teamDto);

        TeamDto result = teamService.save(request);

        assertEquals(teamDto, result);

        verify(teamRepository).save(team);
        verify(teamRepository).existsTeamByName("test");
    }

}