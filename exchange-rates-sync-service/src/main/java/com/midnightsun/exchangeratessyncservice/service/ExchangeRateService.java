package com.midnightsun.exchangeratessyncservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.midnightsun.exchangeratessyncservice.model.ExchangeRate;
import com.midnightsun.exchangeratessyncservice.repository.ExchangeRateRepository;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.service.mapper.ExchangeRateMapper;
import com.midnightsun.exchangeratessyncservice.utils.XmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.io.IOException;

@Slf4j
@Service
public class ExchangeRateService {

    private final Sinks.Many<String> sink;

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    private final ExternalExchangeRateService externalExchangeRateService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExchangeRateService(
            Sinks.Many<String> sink,
            ExchangeRateRepository exchangeRateRepository,
            ExchangeRateMapper exchangeRateMapper,
            ExternalExchangeRateService externalExchangeRateService) {

        this.sink = sink;
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
        this.externalExchangeRateService = externalExchangeRateService;
    }

    public byte[] getExchangeRatesFileContent() throws IOException {
        updateExchangeRates();

        final var mostRecent = exchangeRateRepository.findMostRecent();
        ExchangeRateDTO result = null;
        if (mostRecent.isPresent()) {
            result = exchangeRateMapper.toDTO(mostRecent.get());
        }

        return XmlConverter.objectToXmlByteArray(result);
    }

    private void updateExchangeRates() throws JsonProcessingException {
        log.info("Fetching exchange rates from external service");
        final var externalExchangeRateDTO = externalExchangeRateService.fetchExchangeRates();

        if (externalExchangeRateDTO == null) {
            log.error("Failed to fetch exchange rates");
            return;
        }

        final var entity = exchangeRateMapper.toEntity(externalExchangeRateDTO);
        final var mostRecent = exchangeRateRepository.findMostRecent();

        if (mostRecent.isPresent() && !entity.equals(mostRecent.get())) {
            log.info("Persisting new exchange rates, {}", entity);
            var persistedEntry = exchangeRateMapper.toDTO(exchangeRateRepository.save(entity));

            log.info("Sending new exchange rates to websocket");
            sink.emitNext(objectMapper.writeValueAsString(persistedEntry), Sinks.EmitFailureHandler.FAIL_FAST);
        }
    }
}
