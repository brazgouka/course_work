package com.brazgouka.arbitrager.service;

import com.brazgouka.arbitrager.entity.Arbitrage;
import com.brazgouka.arbitrager.entity.Bet;
import com.brazgouka.arbitrager.entity.Game;
import com.brazgouka.arbitrager.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ArbitrageService {

    private final GameRepository gameRepository;

    public ArbitrageService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Arbitrage> findAll() {
        List<Game> games = gameRepository.findAll();
        List<Arbitrage> arbitrages = new ArrayList<>();

        for (int i = 0; i < games.size(); i++) {
            for (int j = i + 1; j < games.size(); j++) {
                Game fgame = games.get(i);
                Game sgame = games.get(j);
                if (fgame.getFirstTeam().equals(sgame.getFirstTeam()) && fgame.getSecondTeam().equals(sgame.getSecondTeam())) {
                    if ((1 / fgame.getFirstTeamCoefficient() + 1 / sgame.getSecondTeamCoefficient()) < 1) {
                        arbitrages.add(new Arbitrage(fgame.getFirstTeam(), sgame.getSecondTeam(),
                                fgame.getFirstTeamCoefficient(), sgame.getSecondTeamCoefficient(),
                                fgame.getBookmaker(), sgame.getBookmaker(), (1 / fgame.getFirstTeamCoefficient() + 1 / sgame.getSecondTeamCoefficient())));
                    }
                    if ((1 / fgame.getSecondTeamCoefficient() + 1 / sgame.getFirstTeamCoefficient()) < 1) {
                        arbitrages.add(new Arbitrage(fgame.getSecondTeam(), sgame.getFirstTeam(),
                                fgame.getSecondTeamCoefficient(), sgame.getFirstTeamCoefficient(),
                                fgame.getBookmaker(), sgame.getBookmaker(), (1 / fgame.getSecondTeamCoefficient() + 1 / sgame.getFirstTeamCoefficient())));
                    }
                } else if (fgame.getFirstTeam().equals(sgame.getSecondTeam()) && fgame.getSecondTeam().equals(sgame.getFirstTeam())) {
                    if ((1 / fgame.getFirstTeamCoefficient() + 1 / sgame.getFirstTeamCoefficient()) < 1) {
                        arbitrages.add(new Arbitrage(fgame.getFirstTeam(), sgame.getFirstTeam(),
                                fgame.getFirstTeamCoefficient(), sgame.getFirstTeamCoefficient(),
                                fgame.getBookmaker(), sgame.getBookmaker(), (1 / fgame.getFirstTeamCoefficient() + 1 / sgame.getFirstTeamCoefficient())));
                    }
                    if ((1 / fgame.getSecondTeamCoefficient() + 1 / sgame.getSecondTeamCoefficient()) < 1) {
                        arbitrages.add(new Arbitrage(fgame.getSecondTeam(), sgame.getSecondTeam(),
                                fgame.getSecondTeamCoefficient(), sgame.getSecondTeamCoefficient(),
                                fgame.getBookmaker(), sgame.getBookmaker(), (1 / fgame.getSecondTeamCoefficient() + 1 / sgame.getSecondTeamCoefficient())));
                    }
                }
            }
        }
        return arbitrages;
    }

    public Arbitrage findBestArbitrage() {
        return findAll().stream().min(Comparator.comparing(Arbitrage::getArbitrageValue)).get();
    }
}
