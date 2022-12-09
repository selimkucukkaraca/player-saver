package com.demo.playersaver.config;

import com.demo.playersaver.dto.request.CreatePlayerRequest;
import com.demo.playersaver.dto.request.CreateTeamRequest;
import com.demo.playersaver.model.Player;
import com.demo.playersaver.model.Team;
import com.demo.playersaver.service.PlayerService;
import com.demo.playersaver.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class DataLoader implements CommandLineRunner {

   private final TeamService teamService;
   private final PlayerService playerService;

    public DataLoader(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        CreateTeamRequest teamRequest = new CreateTeamRequest();
        teamRequest.setName("philadelphia");

        teamService.save(teamRequest);

        CreatePlayerRequest playerRequest = new CreatePlayerRequest();
        playerRequest.setName("selim");
        playerRequest.setLastname("kucukkaraca");
        playerRequest.setAge(20);
        playerRequest.setMail("selim@gmail.com");
        playerRequest.setTeamName(teamRequest.getName());

        playerService.save(playerRequest);
    }
}
