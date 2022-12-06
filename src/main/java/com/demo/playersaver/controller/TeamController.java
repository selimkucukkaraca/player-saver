package com.demo.playersaver.controller;

import com.demo.playersaver.dto.TeamDto;
import com.demo.playersaver.dto.request.CreateTeamRequest;
import com.demo.playersaver.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> save(@RequestBody CreateTeamRequest request) {
        return ResponseEntity
                .ok(teamService.save(request));
    }
}
