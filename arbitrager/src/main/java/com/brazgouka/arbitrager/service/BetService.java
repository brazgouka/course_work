package com.brazgouka.arbitrager.service;

import com.brazgouka.arbitrager.controller.form.ArbitrageForm;
import com.brazgouka.arbitrager.entity.Arbitrage;
import com.brazgouka.arbitrager.entity.Bet;
import org.springframework.stereotype.Service;

@Service
public class BetService {

    private final ArbitrageService arbitrageService;

    public BetService(final ArbitrageService arbitrageService) {
        this.arbitrageService = arbitrageService;
    }

    public Bet calculateBestBet(final float budget) {
        Arbitrage arbitrage = arbitrageService.findBestArbitrage();
        float firstTeamBet = budget / (arbitrage.getFirstTeamCoefficient() * arbitrage.getArbitrageValue());
        float secondTeamBet = budget / (arbitrage.getSecondTeamCoefficient() * arbitrage.getArbitrageValue());
        float win = firstTeamBet * arbitrage.getFirstTeamCoefficient() - budget;
        return new Bet(arbitrage.getFirstTeam(), arbitrage.getSecondTeam(), firstTeamBet, secondTeamBet,
                arbitrage.getFirstTeamBookmaker(), arbitrage.getSecondTeamBookmaker(), win);
    }

    public Bet calculateBet(final ArbitrageForm arbitrage, final float budget) {
        float firstTeamBet = budget / (arbitrage.getFirstTeamCoefficient() * arbitrage.getArbitrageValue());
        float secondTeamBet = budget / (arbitrage.getSecondTeamCoefficient() * arbitrage.getArbitrageValue());
        float win = firstTeamBet * arbitrage.getFirstTeamCoefficient() - budget;
        return new Bet(arbitrage.getFirstTeam(), arbitrage.getSecondTeam(), firstTeamBet, secondTeamBet,
                arbitrage.getFirstTeamBookmaker(), arbitrage.getSecondTeamBookmaker(), win);
    }
}
