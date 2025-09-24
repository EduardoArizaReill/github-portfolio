package com.example.TrackeGames.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrackeGames.LoginDomain.ChampionMastery;
import com.example.TrackeGames.LoginDomain.Login;
import com.example.TrackeGames.LoginDomain.RespawnPlayer;
import com.example.TrackeGames.LoginRepository.ChampionMasteryRepository;
import com.example.TrackeGames.LoginRepository.LoginRepository;
import com.example.TrackeGames.LoginRepository.RespawnPlayerRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private RespawnPlayerRepository respawnPlayerRepository;

    @Autowired
    private ChampionMasteryRepository championMasteryRepository;

    public Login registerUser(Login user) {
        return loginRepository.save(user);
    }

    public void guardarJugador(String playerName, String ranked, String selectedCharacter) {
    RespawnPlayer player = new RespawnPlayer();
    player.setPlayer_name(playerName);
    player.setRanked(ranked);
    player.setSelected_character(selectedCharacter);
    // No seteamos last_updated porque quieres dejarlo vacío

    respawnPlayerRepository.save(player);
}

        public void saveChampionMasteryData(String puuid, String region, String game_tag, String tag_line,
                                        String champion_name, int championLevel, int championPoints) {
        ChampionMastery mastery = new ChampionMastery();
        mastery.setPuuid(puuid);
        mastery.setRegion(region);
        mastery.setGameTag(game_tag);
        mastery.setTagLine(tag_line);
        mastery.setChampionName(champion_name);
        mastery.setChampionLevel(championLevel);
        mastery.setChampionPoints(championPoints);
        // Puedes omitir last_play_time o dejarlo null

        championMasteryRepository.save(mastery);
    }

    /*public boolean loginUser(String name, String pass) {
        Login user = loginRepository.findByName(name);
        if (user == null) {
            System.out.println("Usuario no encontrado: " + name);
            return false;
        }
        return user.getPass().equals(pass);
    }*/
}