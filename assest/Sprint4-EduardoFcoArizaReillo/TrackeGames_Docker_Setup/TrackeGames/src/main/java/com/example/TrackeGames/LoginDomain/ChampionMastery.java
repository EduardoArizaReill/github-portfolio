package com.example.TrackeGames.LoginDomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "champion_mastery")
public class ChampionMastery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "puuid")
    @JsonProperty("puuid")
    private String puuid;

    @Column(name = "region")
    @JsonProperty("region")
    private String region;

    @Column(name = "game_tag")
    @JsonProperty("game_tag")
    private String gameTag;

    @Column(name = "tag_line")
    @JsonProperty("tag_line")
    private String tagLine;

    @Column(name = "champion_name")
    @JsonProperty("champion_name")
    private String championName;

    @Column(name = "champion_level")
    @JsonProperty("champion_level")
    private int championLevel;

    @Column(name = "champion_points")
    @JsonProperty("champion_points")
    private int championPoints;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGameTag() {
        return gameTag;
    }

    public void setGameTag(String gameTag) {
        this.gameTag = gameTag;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(int championPoints) {
        this.championPoints = championPoints;
    }

    // Opcional: para debug en consola
    @Override
    public String toString() {
        return "ChampionMastery{" +
                "puuid='" + puuid + '\'' +
                ", region='" + region + '\'' +
                ", gameTag='" + gameTag + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", championName='" + championName + '\'' +
                ", championLevel=" + championLevel +
                ", championPoints=" + championPoints +
                '}';
    }
}
