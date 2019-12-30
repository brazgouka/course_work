package com.brazgouka.arbitrager.controller;

import com.brazgouka.arbitrager.entity.Game;
import com.brazgouka.arbitrager.repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private final GameRepository gameRepository;

    public GameController(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/games")
    public List<Game> findAllArbitrages() {
        return gameRepository.findAll();
    }
}
