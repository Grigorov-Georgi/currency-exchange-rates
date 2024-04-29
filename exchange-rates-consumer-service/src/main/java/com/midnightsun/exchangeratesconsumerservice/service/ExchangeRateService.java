package com.midnightsun.exchangeratesconsumerservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midnightsun.exchangeratesconsumerservice.repository.ExchangeRateRepository;
import com.midnightsun.exchangeratesconsumerservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratesconsumerservice.service.mapper.ExchangeRateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
    }

    public void save(String message) {
        log.info("Persisting exchange rates into DB: {}", message);

        try {
            ExchangeRateDTO exchangeRateDTO = objectMapper.readValue(message, ExchangeRateDTO.class);
            exchangeRateRepository.save(exchangeRateMapper.toEntity(exchangeRateDTO));
        } catch (Exception e) {
            log.error("Failed to persist exchange rates: {}", e.getMessage());
        }
    }
}
