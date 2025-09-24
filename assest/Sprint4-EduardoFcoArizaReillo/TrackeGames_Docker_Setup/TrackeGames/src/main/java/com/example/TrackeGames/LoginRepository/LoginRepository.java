package com.example.TrackeGames.LoginRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TrackeGames.LoginDomain.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
