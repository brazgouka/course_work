package com.brazgouka.arbitrager.entity;

public class Arbitrage {

    private String firstTeam;

    private String secondTeam;

    private float firstTeamCoefficient;

    private float secondTeamCoefficient;

    private String firstTeamBookmaker;

    private String secondTeamBookmaker;

    private float arbitrage;

    public Arbitrage(String firstTeam, String secondTeam, float firstTeamCoefficient, float secondTeamCoefficient, String firstTeamBookmaker, String secondTeamBookmaker, float arbitrage) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
        this.firstTeamBookmaker = firstTeamBookmaker;
        this.secondTeamBookmaker = secondTeamBookmaker;
        this.arbitrage = arbitrage;
    }

    public float getArbitrageValue() {
        return (1 / firstTeamCoefficient + 1 / secondTeamCoefficient);
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

    public float getFirstTeamCoefficient() {
        return firstTeamCoefficient;
    }

    public void setFirstTeamCoefficient(float firstTeamCoefficient) {
        this.firstTeamCoefficient = firstTeamCoefficient;
    }

    public float getSecondTeamCoefficient() {
        return secondTeamCoefficient;
    }

    public void setSecondTeamCoefficient(float secondTeamCoefficient) {
        this.secondTeamCoefficient = secondTeamCoefficient;
    }

    public String getFirstTeamBookmaker() {
        return firstTeamBookmaker;
    }

    public void setFirstTeamBookmaker(String firstTeamBookmaker) {
        this.firstTeamBookmaker = firstTeamBookmaker;
    }

    public String getSecondTeamBookmaker() {
        return secondTeamBookmaker;
    }

    public void setSecondTeamBookmaker(String secondTeamBookmaker) {
        this.secondTeamBookmaker = secondTeamBookmaker;
    }

    public float getArbitrage() {
        return arbitrage;
    }

    public void setArbitrage(float arbitrage) {
        this.arbitrage = arbitrage;
    }
}
