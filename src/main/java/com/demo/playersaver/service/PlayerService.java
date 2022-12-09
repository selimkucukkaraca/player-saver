package com.demo.playersaver.service;

import com.demo.playersaver.dto.PlayerDto;
import com.demo.playersaver.dto.converter.PlayerConverter;
import com.demo.playersaver.dto.request.CreatePlayerRequest;
import com.demo.playersaver.exception.PlayerCountLimitExceededException;
import com.demo.playersaver.model.Player;
import com.demo.playersaver.model.Team;
import com.demo.playersaver.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerConverter playerConverter;
    private final TeamService teamService;

    public PlayerService(PlayerRepository playerRepository,
                         PlayerConverter playerConverter,
                         TeamService teamService) {
        this.playerRepository = playerRepository;
        this.playerConverter = playerConverter;
        this.teamService = teamService;
    }

    public PlayerDto save(CreatePlayerRequest request) {
        Team team = teamService.getTeamByName(request.getTeamName());

        var saved = playerConverter.toEntity(request, team);

        if (getPlayerByTeamName(request.getTeamName()).size() > 12){
            throw new PlayerCountLimitExceededException("Maximum number of players reached!");
        }
        playerRepository.save(saved);
        return playerConverter.convertPlayerToPlayerDto(saved);

    }

    public List<PlayerDto> getAll() {
        return playerRepository.findAll()
                .stream()
                .map(player ->
                    new PlayerDto(
                            player.getName(),
                            player.getLastname(),
                            player.getMail(),
                            player.getAge(),
                            teamService.getByName(player.getTeam().getName()),
                            player.getCreateDate(),
                            player.getUpdateDate()
                    )
                )
                .collect(Collectors.toList());
    }

    public void delete(String mail) {
        var fromDbPlayer = getPlayerByMail(mail);

        playerRepository.deleteById(fromDbPlayer.getId());
    }

    public List<PlayerDto> getPlayerByTeamName(String teamName){
        return playerRepository.findAll()
                .stream()
                .filter(player -> player.getTeam().getName().equals(teamName))
                .map(player -> new PlayerDto(
                        player.getName(),
                        player.getLastname(),
                        player.getMail(),
                        player.getAge(),
                        teamService.getByName(player.getTeam().getName()),
                        player.getCreateDate(),
                        player.getUpdateDate()
                ))
                .collect(Collectors.toList());



        /*      USTTEKIYLE AYNI

        List<PlayerDto> playerDtoList = new ArrayList<>();

        for (Player player: playerRepository.findAll()){
            if (player.getTeam().getName().equals(teamName)){
                PlayerDto playerDto = new PlayerDto(player.getName(), player.getLastname(), player.getMail(), player.getAge(),
                        teamService.getByName(player.getTeam().getName()),player.getCreateDate(),player.getUpdateDate());
                playerDtoList.add(playerDto);
            }
        }
        return playerDtoList;
        */
    }




    private Player getPlayerByMail(String mail) {
        return playerRepository.findPlayerByMail(mail);
    }

}
