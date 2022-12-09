package com.demo.playersaver.controller;

import com.demo.playersaver.dto.MatchStatisticDto;
import com.demo.playersaver.dto.request.CreateMatchStatisticRequest;
import com.demo.playersaver.model.MatchStatistic;
import com.demo.playersaver.service.MatchStatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/match-statistic")
public class MatchStatisticController {

    private final MatchStatisticService matchStatisticService;


    public MatchStatisticController(MatchStatisticService matchStatisticService) {
        this.matchStatisticService = matchStatisticService;
    }

    @PostMapping
    public ResponseEntity<MatchStatisticDto> save(@RequestBody CreateMatchStatisticRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(matchStatisticService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<MatchStatisticDto>> getMatchStatisticByPlayerMail(@RequestParam String mail){
        return ResponseEntity
                .ok(matchStatisticService.getMatchStatisticByPlayerMail(mail));
    }


}
