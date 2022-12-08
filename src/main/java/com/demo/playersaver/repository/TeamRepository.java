package com.demo.playersaver.repository;

import com.demo.playersaver.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsTeamByName(String name);
    Optional<Team> findTeamByName(String name);
}
