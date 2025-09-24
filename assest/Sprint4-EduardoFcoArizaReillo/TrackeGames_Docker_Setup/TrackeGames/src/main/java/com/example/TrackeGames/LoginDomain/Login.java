package com.example.TrackeGames.LoginDomain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private int id_users;

    @Column(name = "name") // asegura que use el nombre de columna correcto en MySQL
    private String name;

    @Column(name = "pass") // asegura que use la columna pass
    private String pass;

    // Getters y setters
    public int getIdUsers() {
        return id_users;
    }

    public void setIdUsers(int id_users) {
        this.id_users = id_users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}




