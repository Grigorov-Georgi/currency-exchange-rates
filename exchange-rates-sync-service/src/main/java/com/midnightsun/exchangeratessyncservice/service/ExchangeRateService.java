package com.midnightsun.exchangeratessyncservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.midnightsun.exchangeratessyncservice.model.ExchangeRate;
import com.midnightsun.exchangeratessyncservice.repository.ExchangeRateRepository;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.service.dto.external.ExternalExchangeRateDTO;
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
        ExternalExchangeRateDTO externalExchangeRateDTO = externalExchangeRateService.fetchExchangeRates();
        saveExchangeRates(externalExchangeRateDTO);
        return XmlConverter.objectToXmlByteArray(externalExchangeRateDTO);
    }

    private void saveExchangeRates(ExternalExchangeRateDTO dto) throws JsonProcessingException {
        ExchangeRate entity = exchangeRateMapper.toEntity(dto);
        ExchangeRate mostRecent = exchangeRateRepository.findMostRecent().orElse(null);

        if (!entity.equals(mostRecent)) {
            log.info("Persisting new exchange rates");
            var persistedEntry = exchangeRateMapper.toDTO(exchangeRateRepository.save(entity));

            ObjectMapper objectMapper = new ObjectMapper();
            sink.emitNext(objectMapper.writeValueAsString(persistedEntry), Sinks.EmitFailureHandler.FAIL_FAST);
        }
    }

    public ExchangeRateDTO getMostRecentExchangeRates() {
        ExchangeRate mostRecent = exchangeRateRepository.findMostRecent().orElse(null);
        return exchangeRateMapper.toDTO(mostRecent);
    }
}
