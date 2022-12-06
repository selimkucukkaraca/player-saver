package com.demo.playersaver.repository;

import com.demo.playersaver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByMail(String mail);
    boolean existsPlayerByMail(String mail);
}
