package com.brazgouka.arbitrager.controller;

import com.brazgouka.arbitrager.entity.Arbitrage;
import com.brazgouka.arbitrager.entity.Bet;
import com.brazgouka.arbitrager.service.ArbitrageService;
import com.brazgouka.arbitrager.service.SynchronizationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ArbitrageController {

    private final ArbitrageService arbitrageService;
    private final SynchronizationService synchronizationService;

    public ArbitrageController(final ArbitrageService arbitrageService,
                               final SynchronizationService synchronizationService) {
        this.arbitrageService = arbitrageService;
        this.synchronizationService = synchronizationService;
    }

    @GetMapping
    public void synchronize() throws IOException {
        synchronizationService.synchronize();
    }

    @GetMapping("/arbitrages")
    public List<Arbitrage> findAllArbitrages() {
        return arbitrageService.findAll();
    }

    @GetMapping("/best-arbitrage")
    public Arbitrage findBestArbitrage() {
        return arbitrageService.findBestArbitrage();
    }
}
