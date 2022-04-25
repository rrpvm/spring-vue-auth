package com.rrpvm.testauth.Model;

import com.rrpvm.testauth.entities.User;

public class UserPublicData {
    private String username;
    private int playedGames;
    private int matchMakingRating;
    public UserPublicData() {
    }

    public UserPublicData(String username, int playedGames, int matchMakingRating) {
        this.username = username;
        this.playedGames = playedGames;
        this.matchMakingRating = matchMakingRating;
    }
    public UserPublicData(User fullData) {
        this.username = fullData.getLogin();
        this.playedGames = fullData.getPlayedGames();
        this.matchMakingRating = fullData.getMatchMakingRating();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getMatchMakingRating() {
        return matchMakingRating;
    }

    public void setMatchMakingRating(int matchMakingRating) {
        this.matchMakingRating = matchMakingRating;
    }
}
