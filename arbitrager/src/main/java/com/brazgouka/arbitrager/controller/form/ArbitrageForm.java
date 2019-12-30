package com.brazgouka.arbitrager.controller.form;

public class ArbitrageForm {

    private String firstTeam;

    private String secondTeam;

    private Float firstTeamCoefficient;

    private Float secondTeamCoefficient;

    private String firstTeamBookmaker;

    private String secondTeamBookmaker;

    private Float arbitrage;

    private Float arbitrageValue;

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

    public Float getFirstTeamCoefficient() {
        return firstTeamCoefficient;
    }

    public void setFirstTeamCoefficient(Float firstTeamCoefficient) {
        this.firstTeamCoefficient = firstTeamCoefficient;
    }

    public Float getSecondTeamCoefficient() {
        return secondTeamCoefficient;
    }

    public void setSecondTeamCoefficient(Float secondTeamCoefficient) {
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

    public Float getArbitrage() {
        return arbitrage;
    }

    public void setArbitrage(Float arbitrage) {
        this.arbitrage = arbitrage;
    }

    public Float getArbitrageValue() {
        return arbitrageValue;
    }

    public void setArbitrageValue(Float arbitrageValue) {
        this.arbitrageValue = arbitrageValue;
    }

    public ArbitrageForm(String firstTeam, String secondTeam, Float firstTeamCoefficient, Float secondTeamCoefficient, String firstTeamBookmaker, String secondTeamBookmaker, Float arbitrage, Float arbitrageValue) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
        this.firstTeamBookmaker = firstTeamBookmaker;
        this.secondTeamBookmaker = secondTeamBookmaker;
        this.arbitrage = arbitrage;
        this.arbitrageValue = arbitrageValue;
    }

    public ArbitrageForm() {
    }
}
