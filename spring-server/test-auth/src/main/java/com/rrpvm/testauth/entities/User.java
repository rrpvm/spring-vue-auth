package com.rrpvm.testauth.entities;

import javax.persistence.*;

@Entity
@Table(name = "users", schema="public")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="games_played")
    private Integer playedGames;
    @Column(name="b_public_history")
    private Boolean isPublicHistory;
    @Column(name="match_making_rating")
    private Integer matchMakingRating;

    public User(Integer id, String login, String password, Integer playedGames, Boolean isPublicHistory, Integer matchMakingRating) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.playedGames = playedGames;
        this.isPublicHistory = isPublicHistory;
        this.matchMakingRating = matchMakingRating;
    }
    public User(){
        this.id = -1;
        this.login = new String();
        this.password = new String();
        this.playedGames = -1;
        this.isPublicHistory = false;
        this.matchMakingRating = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Boolean getPublicHistory() {
        return isPublicHistory;
    }

    public void setPublicHistory(Boolean publicHistory) {
        isPublicHistory = publicHistory;
    }

    public Integer getMatchMakingRating() {
        return matchMakingRating;
    }

    public void setMatchMakingRating(Integer matchMakingRating) {
        this.matchMakingRating = matchMakingRating;
    }

}
