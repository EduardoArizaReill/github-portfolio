-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS trackergames;
USE trackergames;

-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id_users INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pass VARCHAR(255) NOT NULL
);

-- Crear la tabla de respawn_players
CREATE TABLE IF NOT EXISTS respawn_players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    ranked VARCHAR(50),
    selected_character VARCHAR(50),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE champion_mastery (
    id INT AUTO_INCREMENT PRIMARY KEY,
    puuid VARCHAR(100) NOT NULL,
    region VARCHAR(10) ,
    game_tag VARCHAR(50),
    tag_line VARCHAR(50) ,
    champion_name VARCHAR(100) ,
    champion_level INT ,
    champion_points INT ,
    last_play_time TIMESTAMP DEFAULT current_timestamp
);


-- Insertar un usuario de prueba
INSERT INTO users (name, pass) VALUES ('admin', 'admin123');
