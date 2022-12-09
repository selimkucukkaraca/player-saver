package com.demo.playersaver.repository;

import com.demo.playersaver.model.MatchStatistic;
import com.demo.playersaver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchStatisticRepository extends JpaRepository<MatchStatistic, Long> {

    List<MatchStatistic> findMatchStatisticByPlayer(Player player);


}
