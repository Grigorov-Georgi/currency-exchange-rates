package com.midnightsun.exchangeratessyncservice.service;

import com.midnightsun.exchangeratessyncservice.model.ExchangeRate;
import com.midnightsun.exchangeratessyncservice.repository.ExchangeRateRepository;
import com.midnightsun.exchangeratessyncservice.service.dto.ExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.service.dto.ExternalExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.service.mapper.ExchangeRateMapper;
import com.midnightsun.exchangeratessyncservice.utils.XmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateMapper exchangeRateMapper;
    private final ExternalExchangeRateService externalExchangeRateService;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateMapper exchangeRateMapper, ExternalExchangeRateService externalExchangeRateService) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateMapper = exchangeRateMapper;
        this.externalExchangeRateService = externalExchangeRateService;
    }

    public byte[] getExchangeRatesFileContent() throws IOException {
        ExternalExchangeRateDTO externalExchangeRateDTO = externalExchangeRateService.fetchExchangeRates();
        saveExchangeRates(externalExchangeRateDTO);
        return XmlConverter.objectToXmlByteArray(externalExchangeRateDTO);
    }

    private void saveExchangeRates(ExternalExchangeRateDTO dto) {
        ExchangeRate entity = exchangeRateMapper.toEntity(dto);
        ExchangeRate mostRecent = exchangeRateRepository.findMostRecent().orElse(null);

        if (!entity.equals(mostRecent)) {
            log.info("Persisting new exchange rates");
            entity.setCreatedBy("system");
            entity.setLastModifiedBy("system");
            exchangeRateRepository.save(entity);
        }
    }

    public ExchangeRateDTO getMostRecentExchangeRates() {
        ExchangeRate mostRecent = exchangeRateRepository.findMostRecent().orElse(null);
        return exchangeRateMapper.toDTO(mostRecent);
    }
}
