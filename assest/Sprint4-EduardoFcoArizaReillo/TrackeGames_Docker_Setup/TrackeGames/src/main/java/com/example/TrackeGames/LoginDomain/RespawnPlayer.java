package com.example.TrackeGames.LoginDomain;
import com.example.TrackeGames.LoginDomain.RespawnPlayer;

import jakarta.persistence.*;

@Entity
@Table(name = "respawn_players")
public class RespawnPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "player_name")
    private String player_name;

    @Column(name = "ranked")
    private String ranked;

    @Column(name = "selected_character")
    private String selected_character;

        // Getters y setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPlayer() {
        return player_name;
    }
    
    public void setPlayer_name(String player_name){
        this.player_name = player_name;
    }

    public String getRanked(){
        return ranked;
    }

    public void setRanked(String ranked){
        this.ranked = ranked;
    }

    public String getSelected_character(){
        return selected_character;
    }

    public void setSelected_character(String selected_character){
        this.selected_character = selected_character;
    }
}


