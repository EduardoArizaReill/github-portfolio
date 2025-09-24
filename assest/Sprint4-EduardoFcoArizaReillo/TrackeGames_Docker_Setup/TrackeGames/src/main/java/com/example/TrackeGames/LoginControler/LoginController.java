package com.example.TrackeGames.LoginControler;

import com.example.TrackeGames.LoginDomain.ChampionMastery;
import com.example.TrackeGames.LoginDomain.Login;
import com.example.TrackeGames.LoginDomain.RespawnPlayer;
import com.example.TrackeGames.LoginRepository.ChampionMasteryRepository;
import com.example.TrackeGames.LoginRepository.RespawnPlayerRepository;
import com.example.TrackeGames.LoginService.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    public Login register(@RequestBody Login user) {
        return loginService.registerUser(user);
    }
    
  /*  @PostMapping("/login")
    @Autowired
    private RespawnPlayerRepository respawnPlayerRepository;




    public String login(@RequestBody Login login) {
        boolean isAuthenticated = loginService.loginUser(login.getName(), login.getPass());
        return isAuthenticated ? "Login successful!" : "Invalid credentials";
    }*/ 

    @Autowired
    private RespawnPlayerRepository respawnPlayerRepository;

    @PostMapping("/apex/save")
    public ResponseEntity<String> savePlayerData(@RequestBody RespawnPlayer player) {
        try {
            respawnPlayerRepository.save(player);
            return ResponseEntity.ok("Datos guardados correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar");
        }
    }

    @Autowired
    private ChampionMasteryRepository championMasteryRepository;

    @PostMapping("/league/save")
    public ResponseEntity<String> saveChampionMastery(@RequestBody ChampionMastery mastery) {
        try {
            // Imprimir cada campo por separado para depuración
            System.out.println("📥 Datos recibidos:");
            System.out.println("PUUID: " + mastery.getPuuid());
            System.out.println("Región: " + mastery.getRegion());
            System.out.println("GameTag: " + mastery.getGameTag());
            System.out.println("TagLine: " + mastery.getTagLine());
            System.out.println("Campeón: " + mastery.getChampionName());
            System.out.println("Nivel del campeón: " + mastery.getChampionLevel());
            System.out.println("Puntos de maestría: " + mastery.getChampionPoints());
    
            // Guardar en la base de datos
            championMasteryRepository.save(mastery);
    
            return ResponseEntity.ok("Datos guardados correctamente");
        } catch (Exception e) {
            e.printStackTrace(); // Para ver el error en consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar");
        }
    }
}