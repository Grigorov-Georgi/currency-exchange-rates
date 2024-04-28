package com.midnightsun.exchangeratessyncservice.service;

import com.midnightsun.exchangeratessyncservice.service.dto.ExternalExchangeRateDTO;
import com.midnightsun.exchangeratessyncservice.utils.XmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class ExchangeRateService {

    private final ExternalExchangeRateService externalExchangeRateService;

    public ExchangeRateService(ExternalExchangeRateService externalExchangeRateService) {
        this.externalExchangeRateService = externalExchangeRateService;
    }

    public byte[] getExchangeRatesFileContent() throws IOException {
        ExternalExchangeRateDTO externalExchangeRateDTO = externalExchangeRateService.fetchExchangeRates();
        return XmlConverter.objectToXmlByteArray(externalExchangeRateDTO);
    }
}
