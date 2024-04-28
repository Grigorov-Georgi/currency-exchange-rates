package com.midnightsun.exchangeratessyncservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ExchangeRateService {

    private final WebClient webClient;

    public ExchangeRateService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void fetchExchangeRates() {
//        Mono<String> response = webClient.get()
//                .uri("/api/exchange-rates")
//                .retrieve()
//                .bodyToMono(String.class);

//        response.subscribe(System.out::println);
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri("http://localhost:8087/api/exchange-rates")
                .retrieve()
                .body(String.class);

        String asd = "asd";
    }
}
