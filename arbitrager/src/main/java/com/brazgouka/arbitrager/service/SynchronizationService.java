package com.brazgouka.arbitrager.service;

import com.brazgouka.arbitrager.entity.Game;
import com.brazgouka.arbitrager.repository.GameRepository;
import com.brazgouka.arbitrager.script.BookmakerParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SynchronizationService {

    private final GameRepository gameRepository;
    private final List<BookmakerParser> parsers;

    public SynchronizationService(final GameRepository gameRepository,
                                  final List<BookmakerParser> parsers) {
        this.gameRepository = gameRepository;
        this.parsers = parsers;
    }

    public void synchronize() throws IOException {
        List<Game> games = new ArrayList<>();
        for (BookmakerParser parser: parsers) {
            games.addAll(parser.parse());
        }
        gameRepository.deleteAll();
        gameRepository.saveAll(games);
    }
}
