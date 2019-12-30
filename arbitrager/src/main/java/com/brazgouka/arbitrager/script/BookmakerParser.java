package com.brazgouka.arbitrager.script;

import com.brazgouka.arbitrager.entity.Game;

import java.io.IOException;
import java.util.List;

public interface BookmakerParser {

    List<Game> parse() throws IOException;

    String getScript();
}
