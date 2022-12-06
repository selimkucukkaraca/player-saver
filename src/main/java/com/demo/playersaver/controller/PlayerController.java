package com.demo.playersaver.controller;

import com.demo.playersaver.dto.PlayerDto;
import com.demo.playersaver.dto.request.CreatePlayerRequest;
import com.demo.playersaver.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerDto> save(@RequestBody CreatePlayerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(playerService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAll() {
        return ResponseEntity
                .ok(playerService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(String mail) {
        playerService.delete(mail);

        return ResponseEntity.noContent().build();
    }
}
