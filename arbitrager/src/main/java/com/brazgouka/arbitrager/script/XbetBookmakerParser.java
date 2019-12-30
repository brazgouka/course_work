package com.brazgouka.arbitrager.script;

import com.brazgouka.arbitrager.entity.Game;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class XbetBookmakerParser implements BookmakerParser {

    @Value("${xbet.parser.path}")
    private String xbetParserScriptPath;

    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public XbetBookmakerParser(final ObjectMapper objectMapper,
                               final RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Game> parse() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:5000/parse-xbet",
                HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        return objectMapper.readValue(response.getBody(), new TypeReference<List<Game>>(){});
    }

    @Override
    public String getScript() {
        return "python " + xbetParserScriptPath;
    }
}
