package com.example.TrackeGames.LoginRepository;

import com.example.TrackeGames.LoginDomain.RespawnPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespawnPlayerRepository extends JpaRepository<RespawnPlayer, Integer> {
}