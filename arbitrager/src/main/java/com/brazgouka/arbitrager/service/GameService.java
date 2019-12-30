package com.brazgouka.arbitrager.service;

import com.brazgouka.arbitrager.entity.Game;
import com.brazgouka.arbitrager.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;


    public GameService(final GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
