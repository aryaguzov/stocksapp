package com.ar.stocksapp;

import com.ar.stocksapp.model.Symbol;
import com.ar.stocksapp.repository.SymbolRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class OnLoadRunner implements CommandLineRunner {
    private final SymbolRepository repository;
    private final RestTemplate restTemplate;

    private final String token = "Tpk_ee567917a6b640bb8602834c9d30e571";
    private final String stocksURL = "https://sandbox.iexapis.com/stable/stock/";

    @Autowired
    public OnLoadRunner(SymbolRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) {
        while (true) {
            save();
            System.out.println("The top 5 highest value stocks: ");
            System.out.println("The most recent 5 companies with the greatest change percent: ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> findEnabledSymbols() {
        String symbolsInfoURL = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=" + token;
        JsonNode response = restTemplate.getForObject(symbolsInfoURL, JsonNode.class);
        Objects.requireNonNull(response, "The response is empty.");

        return StreamSupport.stream(response.spliterator(), true)
                .filter(row -> row.get("isEnabled").asBoolean())
                .map(row -> row.get("symbol").asText())
                .limit(20)
                .collect(Collectors.toList());
    }

    public void save() {
        findEnabledSymbols().forEach(symbolName -> {
            String requestURL = stocksURL + symbolName + "/quote?token=" + token;
            Symbol symbol = restTemplate.getForObject(requestURL, Symbol.class);
            Objects.requireNonNull(symbol);
            repository.save(symbol);
        });
    }
}
