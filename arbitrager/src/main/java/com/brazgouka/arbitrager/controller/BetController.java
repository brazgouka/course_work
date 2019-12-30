package com.brazgouka.arbitrager.controller;

import com.brazgouka.arbitrager.controller.form.ArbitrageForm;
import com.brazgouka.arbitrager.entity.Bet;
import com.brazgouka.arbitrager.service.BetService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetController {

    private final BetService betService;

    public BetController(final BetService betService) {
        this.betService = betService;
    }

    @PostMapping("/calculate-bet/{budget}")
    public Bet calculateBet(@PathVariable float budget, @RequestBody ArbitrageForm arbitrage) {
        return betService.calculateBet(arbitrage, budget);
    }
}
