package com.brazgouka.arbitrager.entity;

public class Bet {

    private String firstTeam;
    private String secondTeam;
    private float firstTeamBet;
    private float secondTeamBet;
    private String firstTeamBetBookmaker;
    private String secondTeamBetBookmaker;
    private float win;

    public Bet(String firstTeam, String secondTeam, float firstTeamBet, float secondTeamBet, String firstTeamBetBookmaker, String secondTeamBetBookmaker, float win) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamBet = firstTeamBet;
        this.secondTeamBet = secondTeamBet;
        this.firstTeamBetBookmaker = firstTeamBetBookmaker;
        this.secondTeamBetBookmaker = secondTeamBetBookmaker;
        this.win = win;
    }

    public float getWin() {
        return win;
    }

    public void setWin(float win) {
        this.win = win;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public float getFirstTeamBet() {
        return firstTeamBet;
    }

    public void setFirstTeamBet(float firstTeamBet) {
        this.firstTeamBet = firstTeamBet;
    }

    public float getSecondTeamBet() {
        return secondTeamBet;
    }

    public void setSecondTeamBet(float secondTeamBet) {
        this.secondTeamBet = secondTeamBet;
    }

    public String getFirstTeamBetBookmaker() {
        return firstTeamBetBookmaker;
    }

    public void setFirstTeamBetBookmaker(String firstTeamBetBookmaker) {
        this.firstTeamBetBookmaker = firstTeamBetBookmaker;
    }

    public String getSecondTeamBetBookmaker() {
        return secondTeamBetBookmaker;
    }

    public void setSecondTeamBetBookmaker(String secondTeamBetBookmaker) {
        this.secondTeamBetBookmaker = secondTeamBetBookmaker;
    }
}
