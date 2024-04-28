package com.midnightsun.exchangeratessyncservice.service;

import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class ExternalExchangeRateService {

    private final RestClient restClient;

    public ExternalExchangeRateService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Cacheable("exchange-rates")
    public ExchangeRateDTO fetchExchangeRates() {
        log.info("Fetching exchange rates from ExchangeRateService");
        return restClient.get()
                .uri("http://localhost:8087/api/exchange-rates")
                .retrieve()
                .body(ExchangeRateDTO.class);
    }
}
