package com.midnightsun.exchangeratessyncservice.service;

import com.midnightsun.exchangeratessyncservice.service.dto.external.ExternalExchangeRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class ExternalExchangeRateService {

    @Value("${exchange-rate-service.url}")
    private String exchangeRateServiceUrl;
    private final RestClient restClient;

    public ExternalExchangeRateService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Cacheable("exchange-rates")
    public ExternalExchangeRateDTO fetchExchangeRates() {
        log.info("Fetching exchange rates from ExchangeRateService");
        return restClient.get()
                .uri(exchangeRateServiceUrl)
                .retrieve()
                .body(ExternalExchangeRateDTO.class);
    }
}
