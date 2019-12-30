package com.brazgouka.arbitrager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name="game")
public class Game {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String firstTeam;
    public String secondTeam;
    public float firstTeamCoefficient;
    public float secondTeamCoefficient;
    public String bookmaker;

    public Game() {
    }

    public Game(String firstTeam, String secondTeam, float firstTeamCoefficient, float secondTeamCoefficient, String bookmaker) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamCoefficient = firstTeamCoefficient;
        this.secondTeamCoefficient = secondTeamCoefficient;
        this.bookmaker = bookmaker;
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

    public String getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(String bookmaker) {
        this.bookmaker = bookmaker;
    }
}
