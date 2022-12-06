package com.demo.playersaver.repository;

import com.demo.playersaver.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsTeamByName(String name);
    Team findTeamByName(String name);
}
